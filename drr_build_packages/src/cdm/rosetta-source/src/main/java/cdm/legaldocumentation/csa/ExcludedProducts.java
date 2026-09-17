package cdm.legaldocumentation.csa;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.legaldocumentation.csa.meta.ExcludedProductsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Description of the relevant derivative transactions excluded from the calculation of exposure.
 * @version 6.23.0
 */
@RosettaDataType(value="ExcludedProducts", builder=ExcludedProducts.ExcludedProductsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ExcludedProducts", model="cdm", builder=ExcludedProducts.ExcludedProductsBuilderImpl.class, version="6.23.0")
public interface ExcludedProducts extends RosettaModelObject {

	ExcludedProductsMeta metaData = new ExcludedProductsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Description of the relevant derivative transactions excluded from the calculation of exposure.
	 */
	List<ExposureScopeProductEnum> getProduct();
	/**
	 * Description of the specific branch entered into by the relevant party.
	 */
	List<BusinessCenterEnum> getBranch();
	/**
	 * A flag to indicate whether transactions entered into by a specific branch with respect to the relevant party are excluded; set to True if excluded, false if included.
	 */
	Boolean getExcluded();

	/*********************** Build Methods  ***********************/
	ExcludedProducts build();
	
	ExcludedProducts.ExcludedProductsBuilder toBuilder();
	
	static ExcludedProducts.ExcludedProductsBuilder builder() {
		return new ExcludedProducts.ExcludedProductsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExcludedProducts> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExcludedProducts> getType() {
		return ExcludedProducts.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("product"), ExposureScopeProductEnum.class, getProduct(), this);
		processor.processBasic(path.newSubPath("branch"), BusinessCenterEnum.class, getBranch(), this);
		processor.processBasic(path.newSubPath("excluded"), Boolean.class, getExcluded(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExcludedProductsBuilder extends ExcludedProducts, RosettaModelObjectBuilder {
		ExcludedProducts.ExcludedProductsBuilder addProduct(ExposureScopeProductEnum product);
		ExcludedProducts.ExcludedProductsBuilder addProduct(ExposureScopeProductEnum product, int idx);
		ExcludedProducts.ExcludedProductsBuilder addProduct(List<ExposureScopeProductEnum> product);
		ExcludedProducts.ExcludedProductsBuilder setProduct(List<ExposureScopeProductEnum> product);
		ExcludedProducts.ExcludedProductsBuilder addBranch(BusinessCenterEnum branch);
		ExcludedProducts.ExcludedProductsBuilder addBranch(BusinessCenterEnum branch, int idx);
		ExcludedProducts.ExcludedProductsBuilder addBranch(List<BusinessCenterEnum> branch);
		ExcludedProducts.ExcludedProductsBuilder setBranch(List<BusinessCenterEnum> branch);
		ExcludedProducts.ExcludedProductsBuilder setExcluded(Boolean excluded);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("product"), ExposureScopeProductEnum.class, getProduct(), this);
			processor.processBasic(path.newSubPath("branch"), BusinessCenterEnum.class, getBranch(), this);
			processor.processBasic(path.newSubPath("excluded"), Boolean.class, getExcluded(), this);
		}
		

		ExcludedProducts.ExcludedProductsBuilder prune();
	}

	/*********************** Immutable Implementation of ExcludedProducts  ***********************/
	class ExcludedProductsImpl implements ExcludedProducts {
		private final List<ExposureScopeProductEnum> product;
		private final List<BusinessCenterEnum> branch;
		private final Boolean excluded;
		
		protected ExcludedProductsImpl(ExcludedProducts.ExcludedProductsBuilder builder) {
			this.product = ofNullable(builder.getProduct()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.branch = ofNullable(builder.getBranch()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.excluded = builder.getExcluded();
		}
		
		@Override
		@RosettaAttribute("product")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("product")
		public List<ExposureScopeProductEnum> getProduct() {
			return product;
		}
		
		@Override
		@RosettaAttribute("branch")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("branch")
		public List<BusinessCenterEnum> getBranch() {
			return branch;
		}
		
		@Override
		@RosettaAttribute("excluded")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("excluded")
		public Boolean getExcluded() {
			return excluded;
		}
		
		@Override
		public ExcludedProducts build() {
			return this;
		}
		
		@Override
		public ExcludedProducts.ExcludedProductsBuilder toBuilder() {
			ExcludedProducts.ExcludedProductsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExcludedProducts.ExcludedProductsBuilder builder) {
			ofNullable(getProduct()).ifPresent(builder::setProduct);
			ofNullable(getBranch()).ifPresent(builder::setBranch);
			ofNullable(getExcluded()).ifPresent(builder::setExcluded);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExcludedProducts _that = getType().cast(o);
		
			if (!ListEquals.listEquals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(branch, _that.getBranch())) return false;
			if (!Objects.equals(excluded, _that.getExcluded())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (product != null ? product.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (branch != null ? branch.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (excluded != null ? excluded.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExcludedProducts {" +
				"product=" + this.product + ", " +
				"branch=" + this.branch + ", " +
				"excluded=" + this.excluded +
			'}';
		}
	}

	/*********************** Builder Implementation of ExcludedProducts  ***********************/
	class ExcludedProductsBuilderImpl implements ExcludedProducts.ExcludedProductsBuilder {
	
		protected List<ExposureScopeProductEnum> product = new ArrayList<>();
		protected List<BusinessCenterEnum> branch = new ArrayList<>();
		protected Boolean excluded;
		
		@Override
		@RosettaAttribute("product")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("product")
		public List<ExposureScopeProductEnum> getProduct() {
			return product;
		}
		
		@Override
		@RosettaAttribute("branch")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("branch")
		public List<BusinessCenterEnum> getBranch() {
			return branch;
		}
		
		@Override
		@RosettaAttribute("excluded")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("excluded")
		public Boolean getExcluded() {
			return excluded;
		}
		
		@RosettaAttribute("product")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("product")
		@Override
		public ExcludedProducts.ExcludedProductsBuilder addProduct(ExposureScopeProductEnum _product) {
			if (_product != null) {
				this.product.add(_product);
			}
			return this;
		}
		
		@Override
		public ExcludedProducts.ExcludedProductsBuilder addProduct(ExposureScopeProductEnum _product, int idx) {
			getIndex(this.product, idx, () -> _product);
			return this;
		}
		
		@Override
		public ExcludedProducts.ExcludedProductsBuilder addProduct(List<ExposureScopeProductEnum> products) {
			if (products != null) {
				for (final ExposureScopeProductEnum toAdd : products) {
					this.product.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("product")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("product")
		@Override
		public ExcludedProducts.ExcludedProductsBuilder setProduct(List<ExposureScopeProductEnum> products) {
			if (products == null) {
				this.product = new ArrayList<>();
			} else {
				this.product = products.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("branch")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("branch")
		@Override
		public ExcludedProducts.ExcludedProductsBuilder addBranch(BusinessCenterEnum _branch) {
			if (_branch != null) {
				this.branch.add(_branch);
			}
			return this;
		}
		
		@Override
		public ExcludedProducts.ExcludedProductsBuilder addBranch(BusinessCenterEnum _branch, int idx) {
			getIndex(this.branch, idx, () -> _branch);
			return this;
		}
		
		@Override
		public ExcludedProducts.ExcludedProductsBuilder addBranch(List<BusinessCenterEnum> branchs) {
			if (branchs != null) {
				for (final BusinessCenterEnum toAdd : branchs) {
					this.branch.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("branch")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("branch")
		@Override
		public ExcludedProducts.ExcludedProductsBuilder setBranch(List<BusinessCenterEnum> branchs) {
			if (branchs == null) {
				this.branch = new ArrayList<>();
			} else {
				this.branch = branchs.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("excluded")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("excluded")
		@Override
		public ExcludedProducts.ExcludedProductsBuilder setExcluded(Boolean _excluded) {
			this.excluded = _excluded == null ? null : _excluded;
			return this;
		}
		
		@Override
		public ExcludedProducts build() {
			return new ExcludedProducts.ExcludedProductsImpl(this);
		}
		
		@Override
		public ExcludedProducts.ExcludedProductsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExcludedProducts.ExcludedProductsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getProduct()!=null && !getProduct().isEmpty()) return true;
			if (getBranch()!=null && !getBranch().isEmpty()) return true;
			if (getExcluded()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExcludedProducts.ExcludedProductsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExcludedProducts.ExcludedProductsBuilder o = (ExcludedProducts.ExcludedProductsBuilder) other;
			
			
			merger.mergeBasic(getProduct(), o.getProduct(), (Consumer<ExposureScopeProductEnum>) this::addProduct);
			merger.mergeBasic(getBranch(), o.getBranch(), (Consumer<BusinessCenterEnum>) this::addBranch);
			merger.mergeBasic(getExcluded(), o.getExcluded(), this::setExcluded);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExcludedProducts _that = getType().cast(o);
		
			if (!ListEquals.listEquals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(branch, _that.getBranch())) return false;
			if (!Objects.equals(excluded, _that.getExcluded())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (product != null ? product.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (branch != null ? branch.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (excluded != null ? excluded.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExcludedProductsBuilder {" +
				"product=" + this.product + ", " +
				"branch=" + this.branch + ", " +
				"excluded=" + this.excluded +
			'}';
		}
	}
}
