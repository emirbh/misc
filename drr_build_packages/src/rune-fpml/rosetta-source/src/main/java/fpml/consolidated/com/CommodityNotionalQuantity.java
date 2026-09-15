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
import fpml.consolidated.com.meta.CommodityNotionalQuantityMeta;
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
 * Provision Commodity Notional.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Commodity Notional.
 *
 */
@RosettaDataType(value="CommodityNotionalQuantity", builder=CommodityNotionalQuantity.CommodityNotionalQuantityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityNotionalQuantity", model="fpml", builder=CommodityNotionalQuantity.CommodityNotionalQuantityBuilderImpl.class, version="2.1.1")
public interface CommodityNotionalQuantity extends RosettaModelObject {

	CommodityNotionalQuantityMeta metaData = new CommodityNotionalQuantityMeta();

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
	 * Provision The frequency at which the Notional Quantity is deemed to apply for purposes of calculating the Total Notional Quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The frequency at which the Notional Quantity is deemed to apply for purposes of calculating the Total Notional Quantity.
	 *
	 */
	CommodityQuantityFrequency getQuantityFrequency();
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
	CommodityNotionalQuantity build();
	
	CommodityNotionalQuantity.CommodityNotionalQuantityBuilder toBuilder();
	
	static CommodityNotionalQuantity.CommodityNotionalQuantityBuilder builder() {
		return new CommodityNotionalQuantity.CommodityNotionalQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityNotionalQuantity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityNotionalQuantity> getType() {
		return CommodityNotionalQuantity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.class, getQuantityUnit());
		processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.class, getQuantityFrequency());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityNotionalQuantityBuilder extends CommodityNotionalQuantity, RosettaModelObjectBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateQuantityUnit();
		@Override
		QuantityUnit.QuantityUnitBuilder getQuantityUnit();
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getOrCreateQuantityFrequency();
		@Override
		CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getQuantityFrequency();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setId(String id);
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit);
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency);
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantity(BigDecimal quantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getQuantityUnit());
			processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder.class, getQuantityFrequency());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		}
		

		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityNotionalQuantity  ***********************/
	class CommodityNotionalQuantityImpl implements CommodityNotionalQuantity {
		private final String id;
		private final QuantityUnit quantityUnit;
		private final CommodityQuantityFrequency quantityFrequency;
		private final BigDecimal quantity;
		
		protected CommodityNotionalQuantityImpl(CommodityNotionalQuantity.CommodityNotionalQuantityBuilder builder) {
			this.id = builder.getId();
			this.quantityUnit = ofNullable(builder.getQuantityUnit()).map(f->f.build()).orElse(null);
			this.quantityFrequency = ofNullable(builder.getQuantityFrequency()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequency")
		public CommodityQuantityFrequency getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		public CommodityNotionalQuantity build() {
			return this;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder toBuilder() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityNotionalQuantity.CommodityNotionalQuantityBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getQuantityUnit()).ifPresent(builder::setQuantityUnit);
			ofNullable(getQuantityFrequency()).ifPresent(builder::setQuantityFrequency);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantity {" +
				"id=" + this.id + ", " +
				"quantityUnit=" + this.quantityUnit + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"quantity=" + this.quantity +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityNotionalQuantity  ***********************/
	class CommodityNotionalQuantityBuilderImpl implements CommodityNotionalQuantity.CommodityNotionalQuantityBuilder {
	
		protected String id;
		protected QuantityUnit.QuantityUnitBuilder quantityUnit;
		protected CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder quantityFrequency;
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
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityFrequency")
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getQuantityFrequency() {
			return quantityFrequency;
		}
		
		@Override
		public CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder getOrCreateQuantityFrequency() {
			CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder result;
			if (quantityFrequency!=null) {
				result = quantityFrequency;
			}
			else {
				result = quantityFrequency = CommodityQuantityFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quantityUnit")
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantityUnit(QuantityUnit _quantityUnit) {
			this.quantityUnit = _quantityUnit == null ? null : _quantityUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantityFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityFrequency")
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantityFrequency(CommodityQuantityFrequency _quantityFrequency) {
			this.quantityFrequency = _quantityFrequency == null ? null : _quantityFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantity")
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@Override
		public CommodityNotionalQuantity build() {
			return new CommodityNotionalQuantity.CommodityNotionalQuantityImpl(this);
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder prune() {
			if (quantityUnit!=null && !quantityUnit.prune().hasData()) quantityUnit = null;
			if (quantityFrequency!=null && !quantityFrequency.prune().hasData()) quantityFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getQuantityUnit()!=null && getQuantityUnit().hasData()) return true;
			if (getQuantityFrequency()!=null && getQuantityFrequency().hasData()) return true;
			if (getQuantity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder o = (CommodityNotionalQuantity.CommodityNotionalQuantityBuilder) other;
			
			merger.mergeRosetta(getQuantityUnit(), o.getQuantityUnit(), this::setQuantityUnit);
			merger.mergeRosetta(getQuantityFrequency(), o.getQuantityFrequency(), this::setQuantityFrequency);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityNotionalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!Objects.equals(quantityFrequency, _that.getQuantityFrequency())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.hashCode() : 0);
			_result = 31 * _result + (quantityFrequency != null ? quantityFrequency.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalQuantityBuilder {" +
				"id=" + this.id + ", " +
				"quantityUnit=" + this.quantityUnit + ", " +
				"quantityFrequency=" + this.quantityFrequency + ", " +
				"quantity=" + this.quantity +
			'}';
		}
	}
}
