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
import fpml.consolidated.com.meta.CommodityExpireRelativeToEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A scheme identifying the physical event relative to which option expiration occurs.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A scheme identifying the physical event relative to which option expiration occurs.
 *
 */
@RosettaDataType(value="CommodityExpireRelativeToEvent", builder=CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityExpireRelativeToEvent", model="fpml", builder=CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilderImpl.class, version="2.1.1")
public interface CommodityExpireRelativeToEvent extends RosettaModelObject {

	CommodityExpireRelativeToEventMeta metaData = new CommodityExpireRelativeToEventMeta();

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
	String getCommodityExpireRelativeToEventScheme();

	/*********************** Build Methods  ***********************/
	CommodityExpireRelativeToEvent build();
	
	CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder toBuilder();
	
	static CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder builder() {
		return new CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityExpireRelativeToEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityExpireRelativeToEvent> getType() {
		return CommodityExpireRelativeToEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityExpireRelativeToEventScheme"), String.class, getCommodityExpireRelativeToEventScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityExpireRelativeToEventBuilder extends CommodityExpireRelativeToEvent, RosettaModelObjectBuilder {
		CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder setValue(String value);
		CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder setCommodityExpireRelativeToEventScheme(String commodityExpireRelativeToEventScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityExpireRelativeToEventScheme"), String.class, getCommodityExpireRelativeToEventScheme(), this);
		}
		

		CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityExpireRelativeToEvent  ***********************/
	class CommodityExpireRelativeToEventImpl implements CommodityExpireRelativeToEvent {
		private final String value;
		private final String commodityExpireRelativeToEventScheme;
		
		protected CommodityExpireRelativeToEventImpl(CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder builder) {
			this.value = builder.getValue();
			this.commodityExpireRelativeToEventScheme = builder.getCommodityExpireRelativeToEventScheme();
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
		@RosettaAttribute("commodityExpireRelativeToEventScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityExpireRelativeToEventScheme")
		public String getCommodityExpireRelativeToEventScheme() {
			return commodityExpireRelativeToEventScheme;
		}
		
		@Override
		public CommodityExpireRelativeToEvent build() {
			return this;
		}
		
		@Override
		public CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder toBuilder() {
			CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityExpireRelativeToEventScheme()).ifPresent(builder::setCommodityExpireRelativeToEventScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityExpireRelativeToEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityExpireRelativeToEventScheme, _that.getCommodityExpireRelativeToEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityExpireRelativeToEventScheme != null ? commodityExpireRelativeToEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityExpireRelativeToEvent {" +
				"value=" + this.value + ", " +
				"commodityExpireRelativeToEventScheme=" + this.commodityExpireRelativeToEventScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityExpireRelativeToEvent  ***********************/
	class CommodityExpireRelativeToEventBuilderImpl implements CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder {
	
		protected String value;
		protected String commodityExpireRelativeToEventScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityExpireRelativeToEventScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityExpireRelativeToEventScheme")
		public String getCommodityExpireRelativeToEventScheme() {
			return commodityExpireRelativeToEventScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("commodityExpireRelativeToEventScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityExpireRelativeToEventScheme")
		@Override
		public CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder setCommodityExpireRelativeToEventScheme(String _commodityExpireRelativeToEventScheme) {
			this.commodityExpireRelativeToEventScheme = _commodityExpireRelativeToEventScheme == null ? null : _commodityExpireRelativeToEventScheme;
			return this;
		}
		
		@Override
		public CommodityExpireRelativeToEvent build() {
			return new CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventImpl(this);
		}
		
		@Override
		public CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityExpireRelativeToEventScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder o = (CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityExpireRelativeToEventScheme(), o.getCommodityExpireRelativeToEventScheme(), this::setCommodityExpireRelativeToEventScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityExpireRelativeToEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityExpireRelativeToEventScheme, _that.getCommodityExpireRelativeToEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityExpireRelativeToEventScheme != null ? commodityExpireRelativeToEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityExpireRelativeToEventBuilder {" +
				"value=" + this.value + ", " +
				"commodityExpireRelativeToEventScheme=" + this.commodityExpireRelativeToEventScheme +
			'}';
		}
	}
}
