import pytest


@pytest.fixture
def test_fixture():
    l = {0,1,2,3,4,5,6,7,8,9,10}
    for s in l:
        sum = sum+s


        assert sum==55
