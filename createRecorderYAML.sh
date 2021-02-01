path="/mnt/stateful_partition/data"
fileName="recorder.yaml"
kubectl node-shell $1 -- mkdir $path;\
echo "vin: tew3t3jwf8wf3f90jowj" > $path/$fileName;\
echo "gpsPosition:" >> $path/$fileName;\
echo "  lat: 3.396887137948883" >> $path/$fileName;\
echo "  lon: 3.284554152400397" >> $path/$fileName;\
echo "mileage:" >> $path/$fileName;\
echo "  city: 144" >> $path/$fileName;\
echo "  autobahn: 125" >> $path/$fileName;\
echo "  country: 307" >> $path/$fileName;\
echo "fillLevels:" >> $path/$fileName;\
echo "  fuel: 71" >> $path/$fileName;\
echo "  coolant: 46" >> $path/$fileName;\
echo "  brakeFluid: 70" >> $path/$fileName;\
echo "  washingWater: 82" >> $path/$fileName;\
echo "embt: 71" >> $path/$fileName;\
echo "lightOperatingHours: 127.11754851718173" >> $path/$fileName;\
echo "tirePressure: 1.5290973413620383" >> $path/$fileName;\
echo "teperature: 12" >> $path/$fileName;\
echo "nodsa: 62" >> $path/$fileName;\
echo "nomi: 55" >> $path/$fileName;\
echo "sblc: 133" >> $path/$fileName;