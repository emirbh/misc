[200~package tests

import (
	"context"
	"encoding/json"
	"os"
	"path/filepath"
	"strings"
	"testing"
	"time"

	"your-project/dmrrepository" // Replace with your actual module path
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/bson/primitive"
)

// TestLocalControlPath_ExtendedJSON tests the full lifecycle of local mode:
// 1. Initial boot (empty file doesn't crash it)
// 2. Data insertion
// 3. Exporting to a file with metadata
// 4. Rebooting a completely new factory instance using that file (Auto-load validation)
func TestLocalControlPath_ExtendedJSON(t *testing.T) {
	ctx := context.Background()
	tempDir := t.TempDir()
	controlPath := filepath.Join(tempDir, "dev_snapshot.json")

	dbName := "test_db"
	collName := "metrics"
	targetID := primitive.NewObjectID()
	targetTime := time.Now().Truncate(time.Millisecond)

	// --- PHASE 1: Fresh Boot & Data Creation ---
	client1, shutdown1, err := dmrrepository.NewClientFactory(ctx, controlPath, dmrrepository.ExtendedJSON)
	if err != nil {
		t.Fatalf("Failed to initialize empty local instance: %v", err)
	}

	col1 := client1.Database(dbName).Collection(collName)
	_, err = col1.InsertOne(ctx, bson.M{
		"_id":        targetID,
		"component":  "auth_service",
		"latency_ms": 120,
		"created_at": targetTime,
	})
	if err != nil {
		t.Fatalf("Failed to insert data: %v", err)
	}

	// Trigger manual export to save state
	err = dmrrepository.ExportCollection(ctx, client1, dbName, collName, controlPath, dmrrepository.ExtendedJSON)
	if err != nil {
		t.Fatalf("Exporting failed: %v", err)
	}
	shutdown1() // Shut down first instance

	// --- VERIFY FILE METADATA STRUCTURE ---
	fileBytes, err := os.ReadFile(controlPath)
	if err != nil {
		t.Fatalf("Failed to read generated export file: %v", err)
	}

	var metadataCheck map[string]interface{}
	if err := json.Unmarshal(fileBytes, &metadataCheck); err != nil {
		t.Fatalf("Export file is not valid JSON: %v", err)
	}

	if metadataCheck["database"] != dbName || metadataCheck["collection"] != collName {
		t.Errorf("Metadata mismatch! Got db=%v, coll=%v", metadataCheck["database"], metadataCheck["collection"])
	}

	// --- PHASE 2: Reboot & Auto-Load Validation ---
	// Instantiate a completely fresh client pointing to the newly populated controlPath file.
	client2, shutdown2, err := dmrrepository.NewClientFactory(ctx, controlPath, dmrrepository.ExtendedJSON)
	if err != nil {
		t.Fatalf("Failed to initialize populated local instance: %v", err)
	}
	defer shutdown2()

	col2 := client2.Database(dbName).Collection(collName)

	var verifiedDoc bson.M
	err = col2.FindOne(ctx, bson.M{"_id": targetID}).Decode(&verifiedDoc)
	if err != nil {
		t.Fatalf("Data lost! Auto-loader failed to populate data from file: %v", err)
	}

	// Strict data type assertion checking
	if _, ok := verifiedDoc["_id"].(primitive.ObjectID); !ok {
		t.Error("Type Assertion Failed: _id did not recover as a native ObjectID")
	}
}

// TestLocalControlPath_StandardJSON validates the code paths for standard JSON
// structure handling inside the controlPath setup.
func TestLocalControlPath_StandardJSON(t *testing.T) {
	ctx := context.Background()
	tempDir := t.TempDir()
	controlPath := filepath.Join(tempDir, "standard_snapshot.json")

	dbName := "config_db"
	collName := "flags"

	// 1. Initial Setup
	client1, shutdown1, _ := dmrrepository.NewClientFactory(ctx, controlPath, dmrrepository.StandardJSON)
	col1 := client1.Database(dbName).Collection(collName)
	_, _ = col1.InsertOne(ctx, bson.M{"feature_toggle": true, "max_users": 500})

	_ = dmrrepository.ExportCollection(ctx, client1, dbName, collName, controlPath, dmrrepository.StandardJSON)
	shutdown1()

	// 2. Refresh verification
	client2, shutdown2, _ := dmrrepository.NewClientFactory(ctx, controlPath, dmrrepository.StandardJSON)
	defer shutdown2()

	col2 := client2.Database(dbName).Collection(collName)
	count, _ := col2.CountDocuments(ctx, bson.M{"feature_toggle": true})
	if count != 1 {
		t.Errorf("Expected standard JSON auto-loader to retrieve 1 record, got %d", count)
	}
}

// TestRemoteControlPathRouting asserts that when the factory encounters a connection string,
// it skips local file creation entirely and routes directly to the network layer.
func TestRemoteControlPathRouting(t *testing.T) {
	ctx := context.Background()

	// We pass a bad MongoDB URI. If it tries to run network driver routing, it will fail to connect.
	// If it incorrectly runs local mode, it would succeed because it would just think "mongodb://" is a file path.
	mockRemoteURI := "mongodb://invalid-unreachable-dead-host:27017"

	_, _, err := dmrrepository.NewClientFactory(ctx, mockRemoteURI, dmrrepository.ExtendedJSON)

	if err == nil {
		t.Fatal("Security Risk: Factory treated a connection string as a local file configuration!")
	}

	// Verify the error message points to a system connection network failure, not a file creation failure.
	if !strings.Contains(err.Error(), "failed remote connection") {
		t.Errorf("Unexpected error messaging context: %v", err)
	}
}
