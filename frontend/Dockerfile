# Use an official lightweight Node.js image
FROM node:alpine

# Set the working directory
WORKDIR /usr/src/app

# Install http-server
RUN npm install -g http-server

# Copy the web files to the container
COPY . .

# Open port 8080
EXPOSE 8080

# Start the http server
CMD ["http-server", ".", "-p 8080"]
