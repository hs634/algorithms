__author__ = 'hs634'

import unittest, math
from unittest.mock import MagicMock

# This version is meant to be copied into coderpad.io
# make sure you use python3, not python 2.7

class PaymentAccount:
  def __init__(self, name, amount):
    self.name = name
    self.amount = amount

    # stub credit method
    self.credit = MagicMock(return_value=True, name='credit')

  def credit(self, amount):
    #Pretend things happen here
    pass

class PaymentSplitter:
  # Implement me!
  def __init__(self, split_type, payment_accounts):
    self.split_type = split_type
    self.payment_accounts = payment_accounts

  def split(self, amount):
    if self.split_type == 'amount':
        rem_amount = amount
        for pa in self.payment_accounts:
            if pa.amount is not None:
                if pa.amount >= rem_amount:
                    pa.credit(rem_amount)
                    break
                else:
                    pa.credit(pa.amount)
                    rem_amount -= pa.amount
            else:
                pa.credit(rem_amount)
    elif self.split_type == 'percentage':
        already_credited = 0
        for index, pa in enumerate(self.payment_accounts):
            integral = math.floor((amount * pa.amount) * 100)/100
            if index == len(self.payment_accounts) - 1:
                integral = round(amount - already_credited, 2)
            already_credited += integral
            pa.credit(integral)


class AmountTest(unittest.TestCase):

  def payment_accounts(self):
    return [
      PaymentAccount('Bank 1', 500.0),
      PaymentAccount('Bank 2', 1500.0),
      PaymentAccount('Bank 3', None)
    ]

  def setUp(self):
    self.payment_accounts = self.payment_accounts()
    self.payment_splitter = PaymentSplitter("amount", self.payment_accounts)

  def tearDown(self):
    del self.payment_accounts
    del self.payment_splitter


  def test_can_split_400(self):
    self.payment_splitter.split(400)

    self.payment_accounts[0].credit.assert_called_with(400.00)
    self.assertFalse(self.payment_accounts[1].credit.called, 'Expected credit to not be called')
    self.assertFalse(self.payment_accounts[2].credit.called, 'Expected credit to not be called')

  def test_can_split_1000(self):
    self.payment_splitter.split(1000)

    self.payment_accounts[0].credit.assert_called_with(500.00)
    self.payment_accounts[1].credit.assert_called_with(500.00)
    self.assertFalse(self.payment_accounts[2].credit.called, 'Expected credit to not be called')

  def test_can_split_3200(self):
    self.payment_splitter.split(3200)

    self.payment_accounts[0].credit.assert_called_with(500.00)
    self.payment_accounts[1].credit.assert_called_with(1500.00)
    self.payment_accounts[2].credit.assert_called_with(1200.00)

class PercentageTest(unittest.TestCase):

  def payment_accounts(self):
    return [
      PaymentAccount('Bank 1', 0.200),
      PaymentAccount('Bank 2', 0.405),
      PaymentAccount('Bank 3', 0.395)
    ]

  def setUp(self):
    self.payment_accounts = self.payment_accounts()
    self.payment_splitter = PaymentSplitter("percentage", self.payment_accounts)

  def tearDown(self):
    del self.payment_accounts
    del self.payment_splitter


  def test_can_split_by_percentage(self):
    self.payment_splitter.split(100)

    self.payment_accounts[0].credit.assert_called_with(20.00)
    self.payment_accounts[1].credit.assert_called_with(40.50)
    self.payment_accounts[2].credit.assert_called_with(39.50)


  def test_with_flooring_to_nearest_cent(self):
    self.payment_splitter.split(801)

    self.payment_accounts[0].credit.assert_called_with(160.20)
    self.payment_accounts[1].credit.assert_called_with(324.40)

  def test_can_split_with_leftover_cents_to_be_added_to_last_transaction(self):
    self.payment_splitter.split(620.97)

    self.payment_accounts[0].credit.assert_called_with(124.19)
    self.payment_accounts[1].credit.assert_called_with(251.49)
    self.payment_accounts[2].credit.assert_called_with(245.29)



if __name__ == '__main__':
    unittest.main()


