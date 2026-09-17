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
import fpml.consolidated.com.meta.MarketDisruptionEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A Market Disruption Event.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A Market Disruption Event.
 *
 */
@RosettaDataType(value="MarketDisruptionEvent", builder=MarketDisruptionEvent.MarketDisruptionEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MarketDisruptionEvent", model="fpml", builder=MarketDisruptionEvent.MarketDisruptionEventBuilderImpl.class, version="2.1.1")
public interface MarketDisruptionEvent extends RosettaModelObject {

	MarketDisruptionEventMeta metaData = new MarketDisruptionEventMeta();

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
	String getCommodityMarketDisruptionScheme();

	/*********************** Build Methods  ***********************/
	MarketDisruptionEvent build();
	
	MarketDisruptionEvent.MarketDisruptionEventBuilder toBuilder();
	
	static MarketDisruptionEvent.MarketDisruptionEventBuilder builder() {
		return new MarketDisruptionEvent.MarketDisruptionEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarketDisruptionEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarketDisruptionEvent> getType() {
		return MarketDisruptionEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityMarketDisruptionScheme"), String.class, getCommodityMarketDisruptionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarketDisruptionEventBuilder extends MarketDisruptionEvent, RosettaModelObjectBuilder {
		MarketDisruptionEvent.MarketDisruptionEventBuilder setValue(String value);
		MarketDisruptionEvent.MarketDisruptionEventBuilder setCommodityMarketDisruptionScheme(String commodityMarketDisruptionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityMarketDisruptionScheme"), String.class, getCommodityMarketDisruptionScheme(), this);
		}
		

		MarketDisruptionEvent.MarketDisruptionEventBuilder prune();
	}

	/*********************** Immutable Implementation of MarketDisruptionEvent  ***********************/
	class MarketDisruptionEventImpl implements MarketDisruptionEvent {
		private final String value;
		private final String commodityMarketDisruptionScheme;
		
		protected MarketDisruptionEventImpl(MarketDisruptionEvent.MarketDisruptionEventBuilder builder) {
			this.value = builder.getValue();
			this.commodityMarketDisruptionScheme = builder.getCommodityMarketDisruptionScheme();
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
		@RosettaAttribute("commodityMarketDisruptionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityMarketDisruptionScheme")
		public String getCommodityMarketDisruptionScheme() {
			return commodityMarketDisruptionScheme;
		}
		
		@Override
		public MarketDisruptionEvent build() {
			return this;
		}
		
		@Override
		public MarketDisruptionEvent.MarketDisruptionEventBuilder toBuilder() {
			MarketDisruptionEvent.MarketDisruptionEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarketDisruptionEvent.MarketDisruptionEventBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityMarketDisruptionScheme()).ifPresent(builder::setCommodityMarketDisruptionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarketDisruptionEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMarketDisruptionScheme, _that.getCommodityMarketDisruptionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMarketDisruptionScheme != null ? commodityMarketDisruptionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarketDisruptionEvent {" +
				"value=" + this.value + ", " +
				"commodityMarketDisruptionScheme=" + this.commodityMarketDisruptionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MarketDisruptionEvent  ***********************/
	class MarketDisruptionEventBuilderImpl implements MarketDisruptionEvent.MarketDisruptionEventBuilder {
	
		protected String value;
		protected String commodityMarketDisruptionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityMarketDisruptionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityMarketDisruptionScheme")
		public String getCommodityMarketDisruptionScheme() {
			return commodityMarketDisruptionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MarketDisruptionEvent.MarketDisruptionEventBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityMarketDisruptionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityMarketDisruptionScheme")
		@Override
		public MarketDisruptionEvent.MarketDisruptionEventBuilder setCommodityMarketDisruptionScheme(String _commodityMarketDisruptionScheme) {
			this.commodityMarketDisruptionScheme = _commodityMarketDisruptionScheme == null ? null : _commodityMarketDisruptionScheme;
			return this;
		}
		
		@Override
		public MarketDisruptionEvent build() {
			return new MarketDisruptionEvent.MarketDisruptionEventImpl(this);
		}
		
		@Override
		public MarketDisruptionEvent.MarketDisruptionEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarketDisruptionEvent.MarketDisruptionEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityMarketDisruptionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarketDisruptionEvent.MarketDisruptionEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarketDisruptionEvent.MarketDisruptionEventBuilder o = (MarketDisruptionEvent.MarketDisruptionEventBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityMarketDisruptionScheme(), o.getCommodityMarketDisruptionScheme(), this::setCommodityMarketDisruptionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarketDisruptionEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityMarketDisruptionScheme, _that.getCommodityMarketDisruptionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityMarketDisruptionScheme != null ? commodityMarketDisruptionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarketDisruptionEventBuilder {" +
				"value=" + this.value + ", " +
				"commodityMarketDisruptionScheme=" + this.commodityMarketDisruptionScheme +
			'}';
		}
	}
}
