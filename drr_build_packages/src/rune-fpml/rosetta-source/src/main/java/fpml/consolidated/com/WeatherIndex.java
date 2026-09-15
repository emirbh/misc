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
import fpml.consolidated.com.meta.WeatherIndexMeta;
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
 * Provision A type defining the Weather Index Level or Weather Index Strike Level.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the Weather Index Level or Weather Index Strike Level.
 *
 */
@RosettaDataType(value="WeatherIndex", builder=WeatherIndex.WeatherIndexBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WeatherIndex", model="fpml", builder=WeatherIndex.WeatherIndexBuilderImpl.class, version="2.1.1")
public interface WeatherIndex extends RosettaModelObject {

	WeatherIndexMeta metaData = new WeatherIndexMeta();

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
	 * Provision This is the Reference Level. The CDD, HDD or HDD Reference Level is specified as the number of (amount of) Weather Index Units specified by the parties in the related Confirmation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This is the Reference Level. The CDD, HDD or HDD Reference Level is specified as the number of (amount of) Weather Index Units specified by the parties in the related Confirmation.
	 *
	 */
	BigDecimal getQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Weather Index Unit derived from one of the following variable methods of determination: Cooling Degree Day (CDD), Heating Degree Day (HDD), Critical Precipitation Day (CPD) as defined in Section 11.15 of the 2005 ISDA Commodity Definitions and User Guide.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Weather Index Unit derived from one of the following variable methods of determination: Cooling Degree Day (CDD), Heating Degree Day (HDD), Critical Precipitation Day (CPD) as defined in Section 11.15 of the 2005 ISDA Commodity Definitions and User Guide.
	 *
	 */
	QuantityUnit getUnit();

	/*********************** Build Methods  ***********************/
	WeatherIndex build();
	
	WeatherIndex.WeatherIndexBuilder toBuilder();
	
	static WeatherIndex.WeatherIndexBuilder builder() {
		return new WeatherIndex.WeatherIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherIndex> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WeatherIndex> getType() {
		return WeatherIndex.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processRosetta(path.newSubPath("unit"), processor, QuantityUnit.class, getUnit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherIndexBuilder extends WeatherIndex, RosettaModelObjectBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateUnit();
		@Override
		QuantityUnit.QuantityUnitBuilder getUnit();
		WeatherIndex.WeatherIndexBuilder setId(String id);
		WeatherIndex.WeatherIndexBuilder setQuantity(BigDecimal quantity);
		WeatherIndex.WeatherIndexBuilder setUnit(QuantityUnit unit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processRosetta(path.newSubPath("unit"), processor, QuantityUnit.QuantityUnitBuilder.class, getUnit());
		}
		

		WeatherIndex.WeatherIndexBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherIndex  ***********************/
	class WeatherIndexImpl implements WeatherIndex {
		private final String id;
		private final BigDecimal quantity;
		private final QuantityUnit unit;
		
		protected WeatherIndexImpl(WeatherIndex.WeatherIndexBuilder builder) {
			this.id = builder.getId();
			this.quantity = builder.getQuantity();
			this.unit = ofNullable(builder.getUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
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
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("unit")
		public QuantityUnit getUnit() {
			return unit;
		}
		
		@Override
		public WeatherIndex build() {
			return this;
		}
		
		@Override
		public WeatherIndex.WeatherIndexBuilder toBuilder() {
			WeatherIndex.WeatherIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherIndex.WeatherIndexBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getUnit()).ifPresent(builder::setUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherIndex _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherIndex {" +
				"id=" + this.id + ", " +
				"quantity=" + this.quantity + ", " +
				"unit=" + this.unit +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherIndex  ***********************/
	class WeatherIndexBuilderImpl implements WeatherIndex.WeatherIndexBuilder {
	
		protected String id;
		protected BigDecimal quantity;
		protected QuantityUnit.QuantityUnitBuilder unit;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
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
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("unit")
		public QuantityUnit.QuantityUnitBuilder getUnit() {
			return unit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (unit!=null) {
				result = unit;
			}
			else {
				result = unit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public WeatherIndex.WeatherIndexBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quantity")
		@Override
		public WeatherIndex.WeatherIndexBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@RosettaAttribute("unit")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("unit")
		@Override
		public WeatherIndex.WeatherIndexBuilder setUnit(QuantityUnit _unit) {
			this.unit = _unit == null ? null : _unit.toBuilder();
			return this;
		}
		
		@Override
		public WeatherIndex build() {
			return new WeatherIndex.WeatherIndexImpl(this);
		}
		
		@Override
		public WeatherIndex.WeatherIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherIndex.WeatherIndexBuilder prune() {
			if (unit!=null && !unit.prune().hasData()) unit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getQuantity()!=null) return true;
			if (getUnit()!=null && getUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherIndex.WeatherIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherIndex.WeatherIndexBuilder o = (WeatherIndex.WeatherIndexBuilder) other;
			
			merger.mergeRosetta(getUnit(), o.getUnit(), this::setUnit);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherIndex _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherIndexBuilder {" +
				"id=" + this.id + ", " +
				"quantity=" + this.quantity + ", " +
				"unit=" + this.unit +
			'}';
		}
	}
}
