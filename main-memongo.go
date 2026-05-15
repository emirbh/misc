package main

import (
	"context"
	"fmt"
	"log"
	"time"

	"github.com/tryvium-travels/memongo"
	"go.mongodb.org/mongo-driver/v2/bson"  // Note the /v2
	"go.mongodb.org/mongo-driver/v2/mongo" // Note the /v2
	"go.mongodb.org/mongo-driver/v2/mongo/options"
)

func main() {
	// 1. memongo setup (stays the same)
	server, err := memongo.Start("6.0.0")
	if err != nil {
		log.Fatal(err)
	}
	defer server.Stop()

	// 2. Connect using v2 Driver
	// v2 has simplified some internal connection logic
	ctx, cancel := context.WithTimeout(context.Background(), 10*time.Second)
	defer cancel()

	client, err := mongo.Connect(options.Client().ApplyURI(server.URI()))
	if err != nil {
		log.Fatal(err)
	}
	defer func() {
		if err = client.Disconnect(ctx); err != nil {
			log.Fatal(err)
		}
	}()

	// 3. Operations (API is almost identical to v1)
	collection := client.Database("dev_db").Collection("users")

	doc := bson.M{"name": "Dev User", "version": "v2"}
	_, err = collection.InsertOne(ctx, doc)
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Successfully inserted and connected using Driver v2!")
}
