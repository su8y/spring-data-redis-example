local current = redis.call('GET', KEYS[1])
if current == false
  then redis.call('SET', KEYS[1], 0)
  current = 0
end
local newValue = tonumber(current) + 1
redis.call('SET', KEYS[1], newValue)
return true;
