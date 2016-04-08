__author__ = 'hs634'

class Crawler(Thread):
    def __init__(self, q, seen, index, lock, wlock, worker_pool_size):
        self.queue = q
        self.seen = seen
        self.index = index
        self.worker_pool_size = worker_pool_size
        self.qandslock = lock
        self.worker_lock = wlock

    def crawl(self, start_url, index):
        cur_page = fetch_page(start_url)
        cur_links = fetch_links(cur_page)

        with self.qandslock:
            for link in cur_links:
                self.queue.enqueue()

        with self.worker_lock:
            self.status = "Free"
            self.worker_available.notify()


class Controller():
    def __init__(self, index):
        self.queue = Queue()
        self.seen = {}
        self.qandslock = Lock()
        self.worker_lock = Lock()
        self.url_available = Condition(self.qandslock)
        self.worker_available = Condition(self.worker_lock)
        self.index = index
        self.worker_pool = [Crawler() for __ in range(worker_pool_size)]

    def run(self, start_url):
        worker = get_next_worker()
        with self.qandslock:
            while self.queue.isEmpty():
                self.url_available.wait()
            next_url = self.queue.dequeue()
        with self.worker_lock:
            while worker_unavailabe():
                self.worker_available.wait()
        worker.crawl(start_url)


