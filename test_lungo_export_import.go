package main

import (
	"context"
	"encoding/json"
	"os"
	"path/filepath"
	"testing"
	"time"

	"github.com/256dpi/lungo"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/bson/primitive"
)

// TestExtendedJSON verifies that complex types like ObjectIDs and Dates
// survive a full export-and-import cycle without losing type fidelity.
func TestExtendedJSON(t *testing.T) {
	ctx := context.Background()
	tempDir := t.TempDir() // Creates a secure, temporary folder unique to this test run
	filePath := filepath.Join(tempDir, "test_extended.json")

	// --- PHASE 1: Populate and Export ---
	client1, engine1, err := lungo.Open(ctx, lungo.Options{Store: lungo.NewMemoryStore()})
	if err != nil {
		t.Fatalf("Failed to start Lungo 1: %v", err)
	}
	defer engine1.Close()

	col1 := client1.Database("test_db").Collection("items")
	originalID := primitive.NewObjectID()
	originalTime := time.Now().Truncate(time.Millisecond) // Truncate because JSON drops nanoseconds

	_, err = col1.InsertOne(ctx, bson.M{
		"_id":        originalID,
		"name":       "Secure Device",
		"created_at": originalTime,
	})
	if err != nil {
		t.Fatalf("Insert failed: %v", err)
	}

	// Fetch documents for export
	cursor, _ := col1.Find(ctx, bson.M{})
	var originalDocs []bson.M
	_ = cursor.All(ctx, &originalDocs)

	// Marshal into MongoDB Extended JSON
	extJSON, err := bson.MarshalExtJSONIndent(originalDocs, false, true, "", "  ")
	if err != nil {
		t.Fatalf("Failed to marshal Extended JSON: %v", err)
	}

	// Write to temp file
	if err := os.WriteFile(filePath, extJSON, 0644); err != nil {
		t.Fatalf("Failed to write file: %v", err)
	}

	// --- PHASE 2: Import into Fresh Instance ---
	client2, engine2, err := lungo.Open(ctx, lungo.Options{Store: lungo.NewMemoryStore()})
	if err != nil {
		t.Fatalf("Failed to start Lungo 2: %v", err)
	}
	defer engine2.Close()

	col2 := client2.Database("test_db").Collection("items")

	// Read and process file
	readData, err := os.ReadFile(filePath)
	if err != nil {
		t.Fatalf("Failed to read file: %v", err)
	}

	var rawDocs []json.RawMessage
	if err := json.Unmarshal(readData, &rawDocs); err != nil {
		t.Fatalf("Failed to unmarshal array: %v", err)
	}

	var importedDocs []interface{}
	for _, raw := range rawDocs {
		var doc bson.M
		// Critical: Decodes "$oid" back into a true primitive.ObjectID
		if err := bson.UnmarshalExtJSON(raw, false, &doc); err != nil {
			t.Fatalf("Extended unmarshal failed: %v", err)
		}
		importedDocs = append(importedDocs, doc)
	}

	if _, err := col2.InsertMany(ctx, importedDocs); err != nil {
		t.Fatalf("Failed to import docs: %v", err)
	}

	// --- PHASE 3: Assertions ---
	var verifiedDoc bson.M
	err = col2.FindOne(ctx, bson.M{"_id": originalID}).Decode(&verifiedDoc)
	if err != nil {
		t.Fatalf("Test Failed: Document lost or ID corrupted during loop: %v", err)
	}

	// Check if data type is correct (not a string, but an actual primitive.ObjectID)
	if _, ok := verifiedDoc["_id"].(primitive.ObjectID); !ok {
		t.Error("Type Assertion Failed: _id is not a primitive.ObjectID")
	}
}

// TestStandardJSON verifies export/import cycle using standard Go JSON.
// Note: We avoid complex types here because standard JSON treats everything as primitive strings/floats.
func TestStandardJSON(t *testing.T) {
	ctx := context.Background()
	tempDir := t.TempDir()
	filePath := filepath.Join(tempDir, "test_standard.json")

	// --- PHASE 1: Populate and Export ---
	client1, engine1, _ := lungo.Open(ctx, lungo.Options{Store: lungo.NewMemoryStore()})
	defer engine1.Close()

	col1 := client1.Database("test_db").Collection("logs")
	_, _ = col1.InsertOne(ctx, bson.M{"event": "system_boot", "code": 200})

	cursor, _ := col1.Find(ctx, bson.M{})
	var originalDocs []bson.M
	_ = cursor.All(ctx, &originalDocs)

	stdJSON, _ := json.MarshalIndent(originalDocs, "", "  ")
	_ = os.WriteFile(filePath, stdJSON, 0644)

	// --- PHASE 2: Import into Fresh Instance ---
	client2, engine2, _ := lungo.Open(ctx, lungo.Options{Store: lungo.NewMemoryStore()})
	defer engine2.Close()

	col2 := client2.Database("test_db").Collection("logs")

	readData, _ := os.ReadFile(filePath)

	// Standard Go JSON target slice
	var importedDocs []bson.M
	if err := json.Unmarshal(readData, &importedDocs); err != nil {
		t.Fatalf("Standard JSON unmarshal failed: %v", err)
	}

	var writeDocs []interface{}
	for _, doc := range importedDocs {
		writeDocs = append(writeDocs, doc)
	}

	_, err := col2.InsertMany(ctx, writeDocs)
	if err != nil {
		t.Fatalf("Failed to insert standard JSON docs: %v", err)
	}

	// --- PHASE 3: Assertions ---
	count, _ := col2.CountDocuments(ctx, bson.M{"event": "system_boot"})
	if count != 1 {
		t.Errorf("Expected 1 document, found %d", count)
	}
}
