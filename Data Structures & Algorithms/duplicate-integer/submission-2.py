class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        set_num = set();
        for i in nums:
            if i in set_num:
                return True
            set_num.add(i)
        return False
        
        