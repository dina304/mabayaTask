# MabayaTask - Dina Goldberg
## API :
 - health check : GET http://<URL>/actuator/health
- Create campaign : POST http://<URL>/actuator/campaign
  body: 
  {
      "name":"string",
      "categoryName":"string from predefined list",
      "bid": <double>,
      "startDate":<timestamp>
  }
- Serve Ad : http://<URL>/serveAd?name=<category name>

# Assumptions: 
 1. Campaign can be created from entire category only. 
    You can't create campaign from list of items
 2. All products in a campaign has the same bid 
 3. Serve Ad API - will retrieve the first product from active campaign by category
 4. I didnt use DB - instead i create map and add items to map 
 5. In order to call Serve Ad and get some data , first need to call Create campaign
 
# Run book :
 start app as spring boot application from TaskApplication Class
