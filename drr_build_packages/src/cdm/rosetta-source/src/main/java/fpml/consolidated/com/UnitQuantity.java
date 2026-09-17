package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.meta.UnitQuantityMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A quantity and associated unit.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A quantity and associated unit.
 *
 */
@RosettaDataType(value="UnitQuantity", builder=UnitQuantity.UnitQuantityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="UnitQuantity", model="fpml", builder=UnitQuantity.UnitQuantityBuilderImpl.class, version="2.1.1")
public interface UnitQuantity extends RosettaModelObject {

	UnitQuantityMeta metaData = new UnitQuantityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Quantity Unit is the unit of measure applicable for the quantity on the Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Quantity Unit is the unit of measure applicable for the quantity on the Transaction.
	 *
	 */
	QuantityUnit getQuantityUnit();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Amount of commodity per quantity frequency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Amount of commodity per quantity frequency.
	 *
	 */
	BigDecimal getQuantity();

	/*********************** Build Methods  ***********************/
	UnitQuantity build();
	
	UnitQuantity.UnitQuantityBuilder toBuilder();
	
	static UnitQuantity.UnitQuantityBuilder builder() {
		return new UnitQuantity.UnitQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnitQuantity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UnitQuantity> getType() {
		return UnitQuantity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.class, getQuantityUnit());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnitQuantityBuilder extends UnitQuantity, RosettaModelObjectBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateQuantityUnit();
		@Override
		QuantityUnit.QuantityUnitBuilder getQuantityUnit();
		UnitQuantity.UnitQuantityBuilder setId(String id);
		UnitQuantity.UnitQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit);
		UnitQuantity.UnitQuantityBuilder setQuantity(BigDecimal quantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getQuantityUnit());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		}
		

		UnitQuantity.UnitQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of UnitQuantity  ***********************/
	class UnitQuantityImpl implements UnitQuantity {
		private final String id;
		private final QuantityUnit quantityUnit;
		private final BigDecimal quantity;
		
		protected UnitQuantityImpl(UnitQuantity.UnitQuantityBuilder builder) {
			this.id = builder.getId();
			this.quantityUnit = ofNullable(builder.getQuantityUnit()).map(f->f.build()).orElse(null);
			this.quantity = builder.getQuantity();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quantityUnit")
		public QuantityUnit getQuantityUnit() {
			return quantityUnit;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		public UnitQuantity build() {
			return this;
		}
		
		@Override
		public UnitQuantity.UnitQuantityBuilder toBuilder() {
			UnitQuantity.UnitQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnitQuantity.UnitQuantityBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getQuantityUnit()).ifPresent(builder::setQuantityUnit);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnitQuantity _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitQuantity {" +
				"id=" + this.id + ", " +
				"quantityUnit=" + this.quantityUnit + ", " +
				"quantity=" + this.quantity +
			'}';
		}
	}

	/*********************** Builder Implementation of UnitQuantity  ***********************/
	class UnitQuantityBuilderImpl implements UnitQuantity.UnitQuantityBuilder {
	
		protected String id;
		protected QuantityUnit.QuantityUnitBuilder quantityUnit;
		protected BigDecimal quantity;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quantityUnit")
		public QuantityUnit.QuantityUnitBuilder getQuantityUnit() {
			return quantityUnit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateQuantityUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (quantityUnit!=null) {
				result = quantityUnit;
			}
			else {
				result = quantityUnit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public UnitQuantity.UnitQuantityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quantityUnit")
		@Override
		public UnitQuantity.UnitQuantityBuilder setQuantityUnit(QuantityUnit _quantityUnit) {
			this.quantityUnit = _quantityUnit == null ? null : _quantityUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quantity")
		@Override
		public UnitQuantity.UnitQuantityBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@Override
		public UnitQuantity build() {
			return new UnitQuantity.UnitQuantityImpl(this);
		}
		
		@Override
		public UnitQuantity.UnitQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitQuantity.UnitQuantityBuilder prune() {
			if (quantityUnit!=null && !quantityUnit.prune().hasData()) quantityUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getQuantityUnit()!=null && getQuantityUnit().hasData()) return true;
			if (getQuantity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitQuantity.UnitQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnitQuantity.UnitQuantityBuilder o = (UnitQuantity.UnitQuantityBuilder) other;
			
			merger.mergeRosetta(getQuantityUnit(), o.getQuantityUnit(), this::setQuantityUnit);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnitQuantity _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitQuantityBuilder {" +
				"id=" + this.id + ", " +
				"quantityUnit=" + this.quantityUnit + ", " +
				"quantity=" + this.quantity +
			'}';
		}
	}
}
