package fpml.consolidated.doc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.doc.meta.TradeTimestampMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A generic trade timestamp
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A generic trade timestamp
 *
 */
@RosettaDataType(value="TradeTimestamp", builder=TradeTimestamp.TradeTimestampBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeTimestamp", model="fpml", builder=TradeTimestamp.TradeTimestampBuilderImpl.class, version="2.1.1")
public interface TradeTimestamp extends RosettaModelObject {

	TradeTimestampMeta metaData = new TradeTimestampMeta();

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
	TimestampTypeScheme _getType();
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
	ZonedDateTime getValue();

	/*********************** Build Methods  ***********************/
	TradeTimestamp build();
	
	TradeTimestamp.TradeTimestampBuilder toBuilder();
	
	static TradeTimestamp.TradeTimestampBuilder builder() {
		return new TradeTimestamp.TradeTimestampBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeTimestamp> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeTimestamp> getType() {
		return TradeTimestamp.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, TimestampTypeScheme.class, _getType());
		processor.processBasic(path.newSubPath("value"), ZonedDateTime.class, getValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTimestampBuilder extends TradeTimestamp, RosettaModelObjectBuilder {
		TimestampTypeScheme.TimestampTypeSchemeBuilder getOrCreateType();
		@Override
		TimestampTypeScheme.TimestampTypeSchemeBuilder _getType();
		TradeTimestamp.TradeTimestampBuilder setType(TimestampTypeScheme type);
		TradeTimestamp.TradeTimestampBuilder setValue(ZonedDateTime value);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, TimestampTypeScheme.TimestampTypeSchemeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("value"), ZonedDateTime.class, getValue(), this);
		}
		

		TradeTimestamp.TradeTimestampBuilder prune();
	}

	/*********************** Immutable Implementation of TradeTimestamp  ***********************/
	class TradeTimestampImpl implements TradeTimestamp {
		private final TimestampTypeScheme type;
		private final ZonedDateTime value;
		
		protected TradeTimestampImpl(TradeTimestamp.TradeTimestampBuilder builder) {
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public TimestampTypeScheme _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("value")
		public ZonedDateTime getValue() {
			return value;
		}
		
		@Override
		public TradeTimestamp build() {
			return this;
		}
		
		@Override
		public TradeTimestamp.TradeTimestampBuilder toBuilder() {
			TradeTimestamp.TradeTimestampBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeTimestamp.TradeTimestampBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTimestamp _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTimestamp {" +
				"type=" + this.type + ", " +
				"value=" + this.value +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTimestamp  ***********************/
	class TradeTimestampBuilderImpl implements TradeTimestamp.TradeTimestampBuilder {
	
		protected TimestampTypeScheme.TimestampTypeSchemeBuilder type;
		protected ZonedDateTime value;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public TimestampTypeScheme.TimestampTypeSchemeBuilder _getType() {
			return type;
		}
		
		@Override
		public TimestampTypeScheme.TimestampTypeSchemeBuilder getOrCreateType() {
			TimestampTypeScheme.TimestampTypeSchemeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = TimestampTypeScheme.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("value")
		public ZonedDateTime getValue() {
			return value;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public TradeTimestamp.TradeTimestampBuilder setType(TimestampTypeScheme _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("value")
		@Override
		public TradeTimestamp.TradeTimestampBuilder setValue(ZonedDateTime _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		public TradeTimestamp build() {
			return new TradeTimestamp.TradeTimestampImpl(this);
		}
		
		@Override
		public TradeTimestamp.TradeTimestampBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTimestamp.TradeTimestampBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null && _getType().hasData()) return true;
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTimestamp.TradeTimestampBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeTimestamp.TradeTimestampBuilder o = (TradeTimestamp.TradeTimestampBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTimestamp _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTimestampBuilder {" +
				"type=" + this.type + ", " +
				"value=" + this.value +
			'}';
		}
	}
}
