from requests import delete


class HashMap:

    def __init__(self, size = 64) -> None:
        self.size = size
        self.map = [None] * size

    def _get_hash(self, key) -> int:
        key = str(key)
        hashed_index = 0
        for c in key:
            hashed_index += ord(c)
        return hashed_index % self.size

    def insert(self, key, value) -> bool:
        hashed_index = self._get_hash(key)
        kv_pair = (key, value)
        if self.map[hashed_index] == None:
            self.map[hashed_index] = [kv_pair]
        else:
            for pair in self.map[hashed_index]:
                if pair[0] == kv_pair[0]:
                    pair[1] = kv_pair[1]
                    return True
            self.map[hashed_index].append(kv_pair)    
        return True

    def get(self, key):
        hashed_index = self._get_hash(key)
        if self.map(hashed_index) != None:
            for pair in self.map[hashed_index]:
                if pair[0] == key:
                    return pair[1]
        return None

    def delete(self, key):
        hashed_index = self._get_hash(key)
        if self.map[hashed_index] != None:
            to_delete = None
            for pair in self.map[hashed_index]:
                if pair[0] == key:
                    to_delete = pair
            if to_delete is not None:
                self.map[hashed_index].remove(to_delete)
                if len(self.map[hashed_index]) == 0:
                    self.map[hashed_index] = None
                    return True
        return False

    def __str__(self):
        str = ''
        str += '{ \n'
        for i in self.map:
            if i is not None:
                for j in i:
                    str += f'   {j[0]} : {j[1]}\n'
        str += '}'
        return str

m = HashMap()
m.insert('abc', 123)
m.delete('abc')
print(m)
