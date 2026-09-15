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
import fpml.consolidated.com.meta.GasProductMeta;
import fpml.consolidated.fpmlenum.GasProductTypeEnum;
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
 * Provision A type defining the characteristics of the gas being traded in a physically settled gas transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the characteristics of the gas being traded in a physically settled gas transaction.
 *
 */
@RosettaDataType(value="GasProduct", builder=GasProduct.GasProductBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GasProduct", model="fpml", builder=GasProduct.GasProductBuilderImpl.class, version="2.1.1")
public interface GasProduct extends RosettaModelObject {

	GasProductMeta metaData = new GasProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of gas to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of gas to be delivered.
	 *
	 */
	GasProductTypeEnum _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The calorific value of the gas to be delivered, specified in megajoules per cubic meter (MJ/m3).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The calorific value of the gas to be delivered, specified in megajoules per cubic meter (MJ/m3).
	 *
	 */
	BigDecimal getCalorificValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The quality of the gas to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The quality of the gas to be delivered.
	 *
	 */
	GasQuality getQuality();

	/*********************** Build Methods  ***********************/
	GasProduct build();
	
	GasProduct.GasProductBuilder toBuilder();
	
	static GasProduct.GasProductBuilder builder() {
		return new GasProduct.GasProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GasProduct> getType() {
		return GasProduct.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("type"), GasProductTypeEnum.class, _getType(), this);
		processor.processBasic(path.newSubPath("calorificValue"), BigDecimal.class, getCalorificValue(), this);
		processRosetta(path.newSubPath("quality"), processor, GasQuality.class, getQuality());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasProductBuilder extends GasProduct, RosettaModelObjectBuilder {
		GasQuality.GasQualityBuilder getOrCreateQuality();
		@Override
		GasQuality.GasQualityBuilder getQuality();
		GasProduct.GasProductBuilder setType(GasProductTypeEnum type);
		GasProduct.GasProductBuilder setCalorificValue(BigDecimal calorificValue);
		GasProduct.GasProductBuilder setQuality(GasQuality quality);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("type"), GasProductTypeEnum.class, _getType(), this);
			processor.processBasic(path.newSubPath("calorificValue"), BigDecimal.class, getCalorificValue(), this);
			processRosetta(path.newSubPath("quality"), processor, GasQuality.GasQualityBuilder.class, getQuality());
		}
		

		GasProduct.GasProductBuilder prune();
	}

	/*********************** Immutable Implementation of GasProduct  ***********************/
	class GasProductImpl implements GasProduct {
		private final GasProductTypeEnum type;
		private final BigDecimal calorificValue;
		private final GasQuality quality;
		
		protected GasProductImpl(GasProduct.GasProductBuilder builder) {
			this.type = builder._getType();
			this.calorificValue = builder.getCalorificValue();
			this.quality = ofNullable(builder.getQuality()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public GasProductTypeEnum _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("calorificValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calorificValue")
		public BigDecimal getCalorificValue() {
			return calorificValue;
		}
		
		@Override
		@RosettaAttribute("quality")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quality")
		public GasQuality getQuality() {
			return quality;
		}
		
		@Override
		public GasProduct build() {
			return this;
		}
		
		@Override
		public GasProduct.GasProductBuilder toBuilder() {
			GasProduct.GasProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasProduct.GasProductBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getCalorificValue()).ifPresent(builder::setCalorificValue);
			ofNullable(getQuality()).ifPresent(builder::setQuality);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasProduct _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(calorificValue, _that.getCalorificValue())) return false;
			if (!Objects.equals(quality, _that.getQuality())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calorificValue != null ? calorificValue.hashCode() : 0);
			_result = 31 * _result + (quality != null ? quality.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasProduct {" +
				"type=" + this.type + ", " +
				"calorificValue=" + this.calorificValue + ", " +
				"quality=" + this.quality +
			'}';
		}
	}

	/*********************** Builder Implementation of GasProduct  ***********************/
	class GasProductBuilderImpl implements GasProduct.GasProductBuilder {
	
		protected GasProductTypeEnum type;
		protected BigDecimal calorificValue;
		protected GasQuality.GasQualityBuilder quality;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public GasProductTypeEnum _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("calorificValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calorificValue")
		public BigDecimal getCalorificValue() {
			return calorificValue;
		}
		
		@Override
		@RosettaAttribute("quality")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quality")
		public GasQuality.GasQualityBuilder getQuality() {
			return quality;
		}
		
		@Override
		public GasQuality.GasQualityBuilder getOrCreateQuality() {
			GasQuality.GasQualityBuilder result;
			if (quality!=null) {
				result = quality;
			}
			else {
				result = quality = GasQuality.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public GasProduct.GasProductBuilder setType(GasProductTypeEnum _type) {
			this.type = _type == null ? null : _type;
			return this;
		}
		
		@RosettaAttribute("calorificValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calorificValue")
		@Override
		public GasProduct.GasProductBuilder setCalorificValue(BigDecimal _calorificValue) {
			this.calorificValue = _calorificValue == null ? null : _calorificValue;
			return this;
		}
		
		@RosettaAttribute("quality")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quality")
		@Override
		public GasProduct.GasProductBuilder setQuality(GasQuality _quality) {
			this.quality = _quality == null ? null : _quality.toBuilder();
			return this;
		}
		
		@Override
		public GasProduct build() {
			return new GasProduct.GasProductImpl(this);
		}
		
		@Override
		public GasProduct.GasProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasProduct.GasProductBuilder prune() {
			if (quality!=null && !quality.prune().hasData()) quality = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null) return true;
			if (getCalorificValue()!=null) return true;
			if (getQuality()!=null && getQuality().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasProduct.GasProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GasProduct.GasProductBuilder o = (GasProduct.GasProductBuilder) other;
			
			merger.mergeRosetta(getQuality(), o.getQuality(), this::setQuality);
			
			merger.mergeBasic(_getType(), o._getType(), this::setType);
			merger.mergeBasic(getCalorificValue(), o.getCalorificValue(), this::setCalorificValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasProduct _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(calorificValue, _that.getCalorificValue())) return false;
			if (!Objects.equals(quality, _that.getQuality())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (calorificValue != null ? calorificValue.hashCode() : 0);
			_result = 31 * _result + (quality != null ? quality.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasProductBuilder {" +
				"type=" + this.type + ", " +
				"calorificValue=" + this.calorificValue + ", " +
				"quality=" + this.quality +
			'}';
		}
	}
}
