package fpml.consolidated.option.shared;

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
import fpml.consolidated.option.shared.meta.MarketDisruptionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines the handling of an averaging date market disruption for an equity derivative transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines the handling of an averaging date market disruption for an equity derivative transaction.
 *
 */
@RosettaDataType(value="MarketDisruption", builder=MarketDisruption.MarketDisruptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MarketDisruption", model="fpml", builder=MarketDisruption.MarketDisruptionBuilderImpl.class, version="2.1.1")
public interface MarketDisruption extends RosettaModelObject {

	MarketDisruptionMeta metaData = new MarketDisruptionMeta();

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
	String getValue();
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
	String getMarketDisruptionScheme();

	/*********************** Build Methods  ***********************/
	MarketDisruption build();
	
	MarketDisruption.MarketDisruptionBuilder toBuilder();
	
	static MarketDisruption.MarketDisruptionBuilder builder() {
		return new MarketDisruption.MarketDisruptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarketDisruption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarketDisruption> getType() {
		return MarketDisruption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("marketDisruptionScheme"), String.class, getMarketDisruptionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarketDisruptionBuilder extends MarketDisruption, RosettaModelObjectBuilder {
		MarketDisruption.MarketDisruptionBuilder setValue(String value);
		MarketDisruption.MarketDisruptionBuilder setMarketDisruptionScheme(String marketDisruptionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("marketDisruptionScheme"), String.class, getMarketDisruptionScheme(), this);
		}
		

		MarketDisruption.MarketDisruptionBuilder prune();
	}

	/*********************** Immutable Implementation of MarketDisruption  ***********************/
	class MarketDisruptionImpl implements MarketDisruption {
		private final String value;
		private final String marketDisruptionScheme;
		
		protected MarketDisruptionImpl(MarketDisruption.MarketDisruptionBuilder builder) {
			this.value = builder.getValue();
			this.marketDisruptionScheme = builder.getMarketDisruptionScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("marketDisruptionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketDisruptionScheme")
		public String getMarketDisruptionScheme() {
			return marketDisruptionScheme;
		}
		
		@Override
		public MarketDisruption build() {
			return this;
		}
		
		@Override
		public MarketDisruption.MarketDisruptionBuilder toBuilder() {
			MarketDisruption.MarketDisruptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarketDisruption.MarketDisruptionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMarketDisruptionScheme()).ifPresent(builder::setMarketDisruptionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarketDisruption _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(marketDisruptionScheme, _that.getMarketDisruptionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (marketDisruptionScheme != null ? marketDisruptionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarketDisruption {" +
				"value=" + this.value + ", " +
				"marketDisruptionScheme=" + this.marketDisruptionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MarketDisruption  ***********************/
	class MarketDisruptionBuilderImpl implements MarketDisruption.MarketDisruptionBuilder {
	
		protected String value;
		protected String marketDisruptionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("marketDisruptionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketDisruptionScheme")
		public String getMarketDisruptionScheme() {
			return marketDisruptionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MarketDisruption.MarketDisruptionBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("marketDisruptionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketDisruptionScheme")
		@Override
		public MarketDisruption.MarketDisruptionBuilder setMarketDisruptionScheme(String _marketDisruptionScheme) {
			this.marketDisruptionScheme = _marketDisruptionScheme == null ? null : _marketDisruptionScheme;
			return this;
		}
		
		@Override
		public MarketDisruption build() {
			return new MarketDisruption.MarketDisruptionImpl(this);
		}
		
		@Override
		public MarketDisruption.MarketDisruptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarketDisruption.MarketDisruptionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMarketDisruptionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarketDisruption.MarketDisruptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarketDisruption.MarketDisruptionBuilder o = (MarketDisruption.MarketDisruptionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMarketDisruptionScheme(), o.getMarketDisruptionScheme(), this::setMarketDisruptionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarketDisruption _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(marketDisruptionScheme, _that.getMarketDisruptionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (marketDisruptionScheme != null ? marketDisruptionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarketDisruptionBuilder {" +
				"value=" + this.value + ", " +
				"marketDisruptionScheme=" + this.marketDisruptionScheme +
			'}';
		}
	}
}
