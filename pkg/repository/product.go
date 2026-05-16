package repository

import (
	"context"
	"time"

	"github.com/256dpi/lungo"
	"go.mongodb.org/mongo-driver/bson"
)

// ProductRepository handles all database interactions for products.
// It uses lungo.IClient so it can work with both raw memory and live MongoDB.
type ProductRepository struct {
	db lungo.IClient
}

// NewProductRepository creates a new instance of the repository
func NewProductRepository(client lungo.IClient) *ProductRepository {
	return &ProductRepository{
		db: client,
	}
}

// SaveProduct inserts a product record. Notice that this uses the exact same 
// syntax as the official go.mongodb.org/mongo-driver/mongo package.
func (r *ProductRepository) SaveProduct(ctx context.Context, name string, price float64) error {
	// This database and collection name will be read by ExportCollection 
	// and stored inside your dev_snapshot.json metadata automatically!
	collection := r.db.Database("app_db").Collection("products")
	
	_, err := collection.InsertOne(ctx, bson.M{
		"name":       name,
		"price":      price,
		"updated_at": time.Now(),
	})
	return err
}
