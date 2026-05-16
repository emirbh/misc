package dmrrepository

import (
	"context"
	"encoding/json"
	"fmt"
	"os"
	"strings"

	"github.com/256dpi/lungo"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/bson/primitive"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
)

type JSONMode int

const (
	StandardJSON JSONMode = iota
	ExtendedJSON
)

// NewClientFactory inspects the controlPath to instantly decide the infrastructure path
func NewClientFactory(ctx context.Context, controlPath string, mode JSONMode) (lungo.IClient, func(), error) {
	// REMOTE PATH: If it has a connection string prefix, hook up to real MongoDB
	if strings.HasPrefix(controlPath, "mongodb://") || strings.HasPrefix(controlPath, "mongodb+srv://") {
		realClient, err := mongo.Connect(options.Client().ApplyURI(controlPath))
		if err != nil {
			return nil, nil, fmt.Errorf("failed remote connection: %w", err)
		}
		return lungo.WrapClient(realClient), func() { _ = realClient.Disconnect(ctx) }, nil
	}

	// LOCAL PATH: Otherwise, treat controlPath as a local database file snapshot
	store := lungo.NewMemoryStore()
	client, engine, err := lungo.Open(ctx, lungo.Options{Store: store})
	if err != nil {
		return nil, nil, fmt.Errorf("failed to start local memory engine: %w", err)
	}

	// Encapsulated Auto-Load: If the snapshot file exists, unpack it immediately
	if _, err := os.Stat(controlPath); err == nil {
		if loadErr := autoLoadSnapshot(ctx, client, controlPath, mode); loadErr != nil {
			fmt.Printf("[LocalDB Warning] Auto-load bypassed (file might be empty/malformed): %v\n", loadErr)
		}
	}

	return client, engine.Close, nil
}

// Hidden internal helper to parse the file metadata and route data into RAM
func autoLoadSnapshot(ctx context.Context, client lungo.IClient, filePath string, mode JSONMode) error {
	fileData, err := os.ReadFile(filePath)
	if err != nil {
		return err
	}

	var dbName, collName string
	var writeItems []interface{}

	if mode == ExtendedJSON {
		var wrapped bson.M
		if err := bson.UnmarshalExtJSON(fileData, false, &wrapped); err != nil {
			return err
		}
		dbName, _ = wrapped["database"].(string)
		collName, _ = wrapped["collection"].(string)
		if rawData, exists := wrapped["data"]; exists {
			if arrayData, ok := rawData.(primitive.A); ok {
				for _, item := range arrayData {
					writeItems = append(writeItems, item)
				}
			}
		}
	} else {
		var wrapped map[string]interface{}
		if err := json.Unmarshal(fileData, &wrapped); err != nil {
			return err
		}
		dbName, _ = wrapped["database"].(string)
		collName, _ = wrapped["collection"].(string)
		if rawData, exists := wrapped["data"]; exists {
			if arrayData, ok := rawData.([]interface{}); ok {
				for _, item := range arrayData {
					writeItems = append(writeItems, item)
				}
			}
		}
	}

	if dbName == "" || collName == "" || len(writeItems) == 0 {
		return nil 
	}

	_, err = client.Database(dbName).Collection(collName).InsertMany(ctx, writeItems)
	return err
}

// ExportCollection safely dumps collections out to disk (Safeguarded against production paths)
func ExportCollection(ctx context.Context, client lungo.IClient, dbName, collName, controlPath string, mode JSONMode) error {
	// Safeguard: If controlPath is a connection string, do NOT attempt to write a file
	if strings.Contains(controlPath, "://") {
		return nil 
	}

	cursor, err := client.Database(dbName).Collection(collName).Find(ctx, bson.M{})
	if err != nil {
		return err
	}
	defer cursor.Close(ctx)

	var documents []bson.M
	if err := cursor.All(ctx, &documents); err != nil {
		return err
	}

	var fileData []byte
	if mode == ExtendedJSON {
		wrapped := bson.M{"database": dbName, "collection": collName, "data": documents}
		fileData, err = bson.MarshalExtJSONIndent(wrapped, false, true, "", "  ")
	} else {
		wrapped := map[string]interface{}{"database": dbName, "collection": collName, "data": documents}
		fileData, err = json.MarshalIndent(wrapped, "", "  ")
	}

	if err != nil {
		return err
	}
	return os.WriteFile(controlPath, fileData, 0644)
}
