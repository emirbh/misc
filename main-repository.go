package main

import (
	"context"
	"fmt"
	"log"
	"strings"

	"your-project/dmrrepository"
	"your-project/repository"
)

func main() {
	ctx := context.Background()

	// =========================================================================
	// CONTROL PATH CONFIGURATION
	// =========================================================================
	// FOR LOCAL DEV: Just pass a file name string
	controlPath := "dev_snapshot.json"

	// FOR PROD/UAT (Uncomment this to swap the entire app over instantly):
	// controlPath := "mongodb://username:password@prod-cluster:27017"
	// =========================================================================

	// 1. Initialize DB. If it's a file path and it exists, loading happens automatically.
	client, shutdown, err := dmrrepository.NewClientFactory(ctx, controlPath, dmrrepository.ExtendedJSON)
	if err != nil {
		log.Fatalf("Database initialization crashed: %v", err)
	}
	defer shutdown()

	// 2. Execute business operations via standard repository injection
	productRepo := repository.NewProductRepository(client)
	_ = productRepo.SaveProduct(ctx, "Encapsulated Network Adapter", 299.99)
	fmt.Println("Business transactions processed successfully.")

	// 3. Graceful Shutdown Export
	// If the control path is a file, automatically dump the updated state to disk
	if !strings.Contains(controlPath, "://") {
		err = dmrrepository.ExportCollection(ctx, client, "app_db", "products", controlPath, dmrrepository.ExtendedJSON)
		if err != nil {
			log.Printf("Failed to preserve state: %v", err)
		} else {
			fmt.Println("Local database delta securely saved back to:", controlPath)
		}
	}
}
