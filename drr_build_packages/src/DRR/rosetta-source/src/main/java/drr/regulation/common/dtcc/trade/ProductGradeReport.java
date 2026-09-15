package drr.regulation.common.dtcc.trade;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import drr.regulation.common.dtcc.trade.meta.ProductGradeReportMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ProductGradeReport", builder=ProductGradeReport.ProductGradeReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ProductGradeReport", model="drr", builder=ProductGradeReport.ProductGradeReportBuilderImpl.class, version="7.7.0")
public interface ProductGradeReport extends RosettaModelObject {

	ProductGradeReportMeta metaData = new ProductGradeReportMeta();

	/*********************** Getter Methods  ***********************/
	List<String> getProductGrade();

	/*********************** Build Methods  ***********************/
	ProductGradeReport build();
	
	ProductGradeReport.ProductGradeReportBuilder toBuilder();
	
	static ProductGradeReport.ProductGradeReportBuilder builder() {
		return new ProductGradeReport.ProductGradeReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProductGradeReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ProductGradeReport> getType() {
		return ProductGradeReport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("productGrade"), String.class, getProductGrade(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductGradeReportBuilder extends ProductGradeReport, RosettaModelObjectBuilder {
		ProductGradeReport.ProductGradeReportBuilder addProductGrade(String productGrade);
		ProductGradeReport.ProductGradeReportBuilder addProductGrade(String productGrade, int idx);
		ProductGradeReport.ProductGradeReportBuilder addProductGrade(List<String> productGrade);
		ProductGradeReport.ProductGradeReportBuilder setProductGrade(List<String> productGrade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("productGrade"), String.class, getProductGrade(), this);
		}
		

		ProductGradeReport.ProductGradeReportBuilder prune();
	}

	/*********************** Immutable Implementation of ProductGradeReport  ***********************/
	class ProductGradeReportImpl implements ProductGradeReport {
		private final List<String> productGrade;
		
		protected ProductGradeReportImpl(ProductGradeReport.ProductGradeReportBuilder builder) {
			this.productGrade = ofNullable(builder.getProductGrade()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productGrade")
		public List<String> getProductGrade() {
			return productGrade;
		}
		
		@Override
		public ProductGradeReport build() {
			return this;
		}
		
		@Override
		public ProductGradeReport.ProductGradeReportBuilder toBuilder() {
			ProductGradeReport.ProductGradeReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductGradeReport.ProductGradeReportBuilder builder) {
			ofNullable(getProductGrade()).ifPresent(builder::setProductGrade);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductGradeReport _that = getType().cast(o);
		
			if (!ListEquals.listEquals(productGrade, _that.getProductGrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (productGrade != null ? productGrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductGradeReport {" +
				"productGrade=" + this.productGrade +
			'}';
		}
	}

	/*********************** Builder Implementation of ProductGradeReport  ***********************/
	class ProductGradeReportBuilderImpl implements ProductGradeReport.ProductGradeReportBuilder {
	
		protected List<String> productGrade = new ArrayList<>();
		
		@Override
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productGrade")
		public List<String> getProductGrade() {
			return productGrade;
		}
		
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productGrade")
		@Override
		public ProductGradeReport.ProductGradeReportBuilder addProductGrade(String _productGrade) {
			if (_productGrade != null) {
				this.productGrade.add(_productGrade);
			}
			return this;
		}
		
		@Override
		public ProductGradeReport.ProductGradeReportBuilder addProductGrade(String _productGrade, int idx) {
			getIndex(this.productGrade, idx, () -> _productGrade);
			return this;
		}
		
		@Override
		public ProductGradeReport.ProductGradeReportBuilder addProductGrade(List<String> productGrades) {
			if (productGrades != null) {
				for (final String toAdd : productGrades) {
					this.productGrade.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productGrade")
		@Override
		public ProductGradeReport.ProductGradeReportBuilder setProductGrade(List<String> productGrades) {
			if (productGrades == null) {
				this.productGrade = new ArrayList<>();
			} else {
				this.productGrade = productGrades.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ProductGradeReport build() {
			return new ProductGradeReport.ProductGradeReportImpl(this);
		}
		
		@Override
		public ProductGradeReport.ProductGradeReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductGradeReport.ProductGradeReportBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getProductGrade()!=null && !getProductGrade().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductGradeReport.ProductGradeReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductGradeReport.ProductGradeReportBuilder o = (ProductGradeReport.ProductGradeReportBuilder) other;
			
			
			merger.mergeBasic(getProductGrade(), o.getProductGrade(), (Consumer<String>) this::addProductGrade);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductGradeReport _that = getType().cast(o);
		
			if (!ListEquals.listEquals(productGrade, _that.getProductGrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (productGrade != null ? productGrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductGradeReportBuilder {" +
				"productGrade=" + this.productGrade +
			'}';
		}
	}
}
