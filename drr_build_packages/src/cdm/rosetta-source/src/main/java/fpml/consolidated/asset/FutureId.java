package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.FutureIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a short form unique identifier for a future contract.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a short form unique identifier for a future contract.
 *
 */
@RosettaDataType(value="FutureId", builder=FutureId.FutureIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FutureId", model="fpml", builder=FutureId.FutureIdBuilderImpl.class, version="2.1.1")
public interface FutureId extends RosettaModelObject {

	FutureIdMeta metaData = new FutureIdMeta();

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
	String getFutureIdScheme();

	/*********************** Build Methods  ***********************/
	FutureId build();
	
	FutureId.FutureIdBuilder toBuilder();
	
	static FutureId.FutureIdBuilder builder() {
		return new FutureId.FutureIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FutureId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FutureId> getType() {
		return FutureId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("futureIdScheme"), String.class, getFutureIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FutureIdBuilder extends FutureId, RosettaModelObjectBuilder {
		FutureId.FutureIdBuilder setValue(String value);
		FutureId.FutureIdBuilder setFutureIdScheme(String futureIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("futureIdScheme"), String.class, getFutureIdScheme(), this);
		}
		

		FutureId.FutureIdBuilder prune();
	}

	/*********************** Immutable Implementation of FutureId  ***********************/
	class FutureIdImpl implements FutureId {
		private final String value;
		private final String futureIdScheme;
		
		protected FutureIdImpl(FutureId.FutureIdBuilder builder) {
			this.value = builder.getValue();
			this.futureIdScheme = builder.getFutureIdScheme();
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
		@RosettaAttribute("futureIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("futureIdScheme")
		public String getFutureIdScheme() {
			return futureIdScheme;
		}
		
		@Override
		public FutureId build() {
			return this;
		}
		
		@Override
		public FutureId.FutureIdBuilder toBuilder() {
			FutureId.FutureIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FutureId.FutureIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getFutureIdScheme()).ifPresent(builder::setFutureIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FutureId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(futureIdScheme, _that.getFutureIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (futureIdScheme != null ? futureIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureId {" +
				"value=" + this.value + ", " +
				"futureIdScheme=" + this.futureIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of FutureId  ***********************/
	class FutureIdBuilderImpl implements FutureId.FutureIdBuilder {
	
		protected String value;
		protected String futureIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("futureIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("futureIdScheme")
		public String getFutureIdScheme() {
			return futureIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public FutureId.FutureIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("futureIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("futureIdScheme")
		@Override
		public FutureId.FutureIdBuilder setFutureIdScheme(String _futureIdScheme) {
			this.futureIdScheme = _futureIdScheme == null ? null : _futureIdScheme;
			return this;
		}
		
		@Override
		public FutureId build() {
			return new FutureId.FutureIdImpl(this);
		}
		
		@Override
		public FutureId.FutureIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FutureId.FutureIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getFutureIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FutureId.FutureIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FutureId.FutureIdBuilder o = (FutureId.FutureIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getFutureIdScheme(), o.getFutureIdScheme(), this::setFutureIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FutureId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(futureIdScheme, _that.getFutureIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (futureIdScheme != null ? futureIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureIdBuilder {" +
				"value=" + this.value + ", " +
				"futureIdScheme=" + this.futureIdScheme +
			'}';
		}
	}
}
