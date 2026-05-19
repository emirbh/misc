package main

import (
	"context"
	"fmt"
	"log"

	"github.com/256dpi/lungo"
	"go.mongodb.org/mongo-driver/bson"
)

func main() {
	// 1. Setup the Store
	// Using NewFileStore ensures data is dumped to 'data.bson' on every change.
	// Use lungo.NewMemoryStore() if you want it strictly in-memory (no file).
	store := lungo.NewFileStore("data.bson", 0666)

	// 2. Initialize the Engine and Client
	// This opens the database and loads existing data from the file if it exists.
	client, engine, err := lungo.Open(context.Background(), lungo.Options{
		Store:          store,
		ExpireInterval: 0, // Set to a duration if you want TTL index support
	})
	if err != nil {
		log.Fatal("Failed to open Lungo:", err)
	}

	// Ensure the engine closes gracefully
	defer engine.Close()

	// 3. Access a Collection
	// The API is identical to the official mongo-go-driver
	collection := client.Database("dev_db").Collection("projects")

	// 4. Perform a Write (Insert)
	newProject := bson.M{
		"name":   "Standalone Project",
		"type":   "Go",
		"status": "active",
	}

	insertRes, err := collection.InsertOne(context.Background(), newProject)
	if err != nil {
		log.Fatal("Insert failed:", err)
	}
	fmt.Printf("Inserted document with ID: %v\n", insertRes.InsertedID)

	// 5. Perform a Read (Find)
	var result bson.M
	err = collection.FindOne(context.Background(), bson.M{"name": "Standalone Project"}).Decode(&result)
	if err != nil {
		fmt.Println("Could not find document.")
	} else {
		fmt.Printf("Found Project: %v\n", result["name"])
	}

	fmt.Println("Database successfully synced to data.bson")
}
