package main

import (
	"context"
	"fmt"
	"log"
	"os"
	"os/signal"
	"path/filepath"
	"syscall"

	"github.com/256dpi/lungo"
	"go.mongodb.org/mongo-driver/bson"
)

func main() {
	// 1. Define a "Safe" Windows Path
	// Using filepath.Abs ensures Windows gets a clean, absolute path string.
	dbPath, _ := filepath.Abs("backup.bson")
	fmt.Printf("Database file will be: %s\n", dbPath)

	// 2. Prepare the Stores
	memoryStore := lungo.NewMemoryStore()
	fileStore := lungo.NewFileStore(dbPath, 0666)

	// 3. (Optional) Load existing data into Memory
	// If the file exists, we "seed" our memory store with its contents.
	initialData, err := fileStore.Load()
	if err == nil {
		memoryStore.Store(initialData)
		fmt.Println("Existing data loaded from file into memory.")
	}

	// 4. Start the Engine using the Memory Store
	client, engine, err := lungo.Open(context.Background(), lungo.Options{
		Store: memoryStore,
	})
	if err != nil {
		log.Fatal(err)
	}

	// --- Your App Logic Starts Here ---
	col := client.Database("test").Collection("data")
	col.InsertOne(context.Background(), bson.M{"msg": "This is in RAM!"})
	// --- Your App Logic Ends Here ---

	// 5. Handle Graceful Shutdown and "Auto-Save"
	// We listen for Ctrl+C so we can dump the memory to the file before exiting.
	stop := make(chan os.Signal, 1)
	signal.Notify(stop, os.Interrupt, syscall.SIGTERM)

	fmt.Println("App is running. Press Ctrl+C to save and exit.")
	<-stop // Wait for user to hit Ctrl+C

	fmt.Println("\nShutting down... saving memory to disk...")
	
	// 6. DUMP: Get the current "Catalog" (state) from memory and save to file
	currentData := engine.Emit()
	err = fileStore.Store(currentData)
	if err != nil {
		fmt.Printf("Failed to save to disk: %v\n", err)
	} else {
		fmt.Println("Save successful! You can restart the app and data will persist.")
	}

	engine.Close()
}
