# -*- coding: utf-8 -*-
__author__ = 'harsh'

import re
import csv

def create_csv(allwriter):
    file_dict = {'chap1': {'section': '7 U.S. Code § 1a', 'catchline': 'Definitions', \
                           'scope': 'As used in this chapter:',
                          },
                 'chap6A': {'section': '7 U.S. Code § 138', 'catchline': 'Definitions', \
                           'scope': 'As used in this chapter:',
                          },
                 'chap10': {'section': '7 U.S. Code § 241', 'catchline': 'Definitions', \
                           'scope': 'In this chapter:',
                          },
                 'chap21CI': {'section': '7 U.S. Code § 518', 'catchline': 'Definitions', \
                           'scope': 'In this subchapter and subchapter II:',
                          },
                 'chap113': {'section': '7 U.S. Code § 8751', 'catchline': 'Definitions', \
                           'scope': 'In this subchapter:',
                          },
                 'chap111': {'section': '7 U.S. Code § 8501', 'catchline': 'Definitions', \
                           'scope': 'In this chapter:',
                          },
                 'chap114': {'section': '7 U.S. Code § 8901', 'catchline': 'Definitions', \
                           'scope': 'In this chapter:',
                          },
                 'chap75': {'section': '7 U.S. Code § 4402', 'catchline': 'Definitions', \
                           'scope': 'As used in this chapter—',
                          },
                 'chap74': {'section': '7 U.S. Code § 4302', 'catchline': 'Definitions', \
                           'scope': 'As used in this chapter—',
                          }
                }

    for chap, chap_det in file_dict.items():
        with open(chap + '.txt', 'r') as f:
            ofile = open(chap + '.csv', 'w')
            writer = csv.writer(ofile, delimiter=',', quotechar='"', quoting=csv.QUOTE_ALL)
            writer.writerow(['Section', 'Catchline', 'Definiendum', 'Definition', 'Scope'])

            section = chap_det['section']
            catchline = chap_det['catchline']
            scope = chap_det['scope']

            read_data = f.read()
            defns = list(filter(None, re.split(r'^\(\d+\)', read_data, 0, re.MULTILINE)))

            for defn in defns:
                heading, desc = defn.strip().partition('\n')[::2]
                row = [section, catchline, heading, desc, scope]
                writer.writerow(row)
                allwriter.writerow(row)

            ofile.close()


def create_csv_format2(allwriter):
    file_dict = {'chap2': {'section': '7 U.S. Code § 62', 'catchline': 'Definitions', \
                           'scope': 'Wherever used in this chapter,', 'bullet_style': 'str',
                          },
                 'chap3': {'section': '7 U.S. Code § 75', 'catchline': 'Definitions', \
                           'scope': 'When used in this chapter, except where the context requires otherwise—',
                           'bullet_style': 'str',
                          },
                 'chap4': {'section': '7 U.S. Code § 92', 'catchline': 'Definitions', \
                           'scope': 'When used in this chapter—', 'bullet_style': 'str',
                          },
                 'chap8AII': {'section': '7 U.S. Code § 178a', 'catchline': 'Definitions', \
                           'scope': 'As used in this subchapter—', 'bullet_style': 'str',
                          },
                 'chap21A': {'section': '7 U.S. Code § 511', 'catchline': 'Definitions', \
                           'scope': 'When used in this chapter—', 'bullet_style': 'str',
                          },
                 'chap62': {'section': '7 U.S. Code § 2902', 'catchline': 'Definitions', \
                           'scope': 'For purposes of this chapter—', 'bullet_style': 'num',
                          },
                 'chap65': {'section': '7 U.S. Code § 3402', 'catchline': 'Definitions', \
                           'scope': 'For the purposes of this chapter:', 'bullet_style': 'str',
                          },

                }
    for chap, chap_det in file_dict.items():
        with open(chap + '.txt', 'r') as f:
            ofile = open(chap + '.csv', 'w')
            writer = csv.writer(ofile, delimiter=',', quotechar='"', quoting=csv.QUOTE_ALL)
            writer.writerow(['Section', 'Catchline', 'Definiendum', 'Definition', 'Scope'])

            section = chap_det['section']
            catchline = chap_det['catchline']
            scope = chap_det['scope']

            read_data = f.read()
            if chap_det['bullet_style'] == 'str':
                defns = list(filter(None, re.split(r'^\([a-z]\)', read_data, 0, re.MULTILINE)))
            elif chap_det['bullet_style'] == 'num':
                defns = list(filter(None, re.split(r'^\(\d+\)', read_data, 0, re.MULTILINE)))


            for defn in defns:
                match = re.findall(r'“(.+?)”', defn.strip())
                heading = match[0]
                desc = defn.rstrip("\n")
                row = [section, catchline, heading, desc, scope]
                writer.writerow(row)
                allwriter.writerow(row)

            ofile.close()



def main():
    allfile = open('alldef.csv', 'w')
    all_writer = csv.writer(allfile, delimiter=',', quotechar='"', quoting=csv.QUOTE_ALL)
    all_writer.writerow(['Section', 'Catchline', 'Definiendum', 'Definition', 'Scope'])
    create_csv(all_writer)
    create_csv_format2(all_writer)
    allfile.close()


if __name__ == '__main__':
    main()

