package fpml.consolidated;

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
import fpml.consolidated.meta.SPKIDataTypeSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="SPKIDataTypeSequence", builder=SPKIDataTypeSequence.SPKIDataTypeSequenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SPKIDataTypeSequence", model="fpml", builder=SPKIDataTypeSequence.SPKIDataTypeSequenceBuilderImpl.class, version="2.1.1")
public interface SPKIDataTypeSequence extends RosettaModelObject {

	SPKIDataTypeSequenceMeta metaData = new SPKIDataTypeSequenceMeta();

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
	String getSpkiSexp();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 0; Max Occurs: 1; Namespace: ##other; Process Contents: lax.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 0; Max Occurs: 1; Namespace: ##other; Process Contents: lax.
	 *
	 */
	String getAnyContents();

	/*********************** Build Methods  ***********************/
	SPKIDataTypeSequence build();
	
	SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder toBuilder();
	
	static SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder builder() {
		return new SPKIDataTypeSequence.SPKIDataTypeSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SPKIDataTypeSequence> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SPKIDataTypeSequence> getType() {
		return SPKIDataTypeSequence.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("spkiSexp"), String.class, getSpkiSexp(), this);
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SPKIDataTypeSequenceBuilder extends SPKIDataTypeSequence, RosettaModelObjectBuilder {
		SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder setSpkiSexp(String spkiSexp);
		SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder setAnyContents(String anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("spkiSexp"), String.class, getSpkiSexp(), this);
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of SPKIDataTypeSequence  ***********************/
	class SPKIDataTypeSequenceImpl implements SPKIDataTypeSequence {
		private final String spkiSexp;
		private final String anyContents;
		
		protected SPKIDataTypeSequenceImpl(SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder builder) {
			this.spkiSexp = builder.getSpkiSexp();
			this.anyContents = builder.getAnyContents();
		}
		
		@Override
		@RosettaAttribute("spkiSexp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("spkiSexp")
		public String getSpkiSexp() {
			return spkiSexp;
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@Override
		public SPKIDataTypeSequence build() {
			return this;
		}
		
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder toBuilder() {
			SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder builder) {
			ofNullable(getSpkiSexp()).ifPresent(builder::setSpkiSexp);
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SPKIDataTypeSequence _that = getType().cast(o);
		
			if (!Objects.equals(spkiSexp, _that.getSpkiSexp())) return false;
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spkiSexp != null ? spkiSexp.hashCode() : 0);
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SPKIDataTypeSequence {" +
				"spkiSexp=" + this.spkiSexp + ", " +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of SPKIDataTypeSequence  ***********************/
	class SPKIDataTypeSequenceBuilderImpl implements SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder {
	
		protected String spkiSexp;
		protected String anyContents;
		
		@Override
		@RosettaAttribute("spkiSexp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("spkiSexp")
		public String getSpkiSexp() {
			return spkiSexp;
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@RosettaAttribute("spkiSexp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("spkiSexp")
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder setSpkiSexp(String _spkiSexp) {
			this.spkiSexp = _spkiSexp == null ? null : _spkiSexp;
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("anyContents")
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder setAnyContents(String _anyContents) {
			this.anyContents = _anyContents == null ? null : _anyContents;
			return this;
		}
		
		@Override
		public SPKIDataTypeSequence build() {
			return new SPKIDataTypeSequence.SPKIDataTypeSequenceImpl(this);
		}
		
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpkiSexp()!=null) return true;
			if (getAnyContents()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder o = (SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder) other;
			
			
			merger.mergeBasic(getSpkiSexp(), o.getSpkiSexp(), this::setSpkiSexp);
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), this::setAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SPKIDataTypeSequence _that = getType().cast(o);
		
			if (!Objects.equals(spkiSexp, _that.getSpkiSexp())) return false;
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spkiSexp != null ? spkiSexp.hashCode() : 0);
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SPKIDataTypeSequenceBuilder {" +
				"spkiSexp=" + this.spkiSexp + ", " +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
