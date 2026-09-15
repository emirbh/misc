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
import fpml.consolidated.meta.ObjectTypeSequenceMeta;
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
@RosettaDataType(value="ObjectTypeSequence", builder=ObjectTypeSequence.ObjectTypeSequenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObjectTypeSequence", model="fpml", builder=ObjectTypeSequence.ObjectTypeSequenceBuilderImpl.class, version="2.1.1")
public interface ObjectTypeSequence extends RosettaModelObject {

	ObjectTypeSequenceMeta metaData = new ObjectTypeSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##any; Process Contents: lax.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##any; Process Contents: lax.
	 *
	 */
	String getAnyContents();

	/*********************** Build Methods  ***********************/
	ObjectTypeSequence build();
	
	ObjectTypeSequence.ObjectTypeSequenceBuilder toBuilder();
	
	static ObjectTypeSequence.ObjectTypeSequenceBuilder builder() {
		return new ObjectTypeSequence.ObjectTypeSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObjectTypeSequence> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObjectTypeSequence> getType() {
		return ObjectTypeSequence.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObjectTypeSequenceBuilder extends ObjectTypeSequence, RosettaModelObjectBuilder {
		ObjectTypeSequence.ObjectTypeSequenceBuilder setAnyContents(String anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		ObjectTypeSequence.ObjectTypeSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of ObjectTypeSequence  ***********************/
	class ObjectTypeSequenceImpl implements ObjectTypeSequence {
		private final String anyContents;
		
		protected ObjectTypeSequenceImpl(ObjectTypeSequence.ObjectTypeSequenceBuilder builder) {
			this.anyContents = builder.getAnyContents();
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@Override
		public ObjectTypeSequence build() {
			return this;
		}
		
		@Override
		public ObjectTypeSequence.ObjectTypeSequenceBuilder toBuilder() {
			ObjectTypeSequence.ObjectTypeSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObjectTypeSequence.ObjectTypeSequenceBuilder builder) {
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObjectTypeSequence _that = getType().cast(o);
		
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObjectTypeSequence {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of ObjectTypeSequence  ***********************/
	class ObjectTypeSequenceBuilderImpl implements ObjectTypeSequence.ObjectTypeSequenceBuilder {
	
		protected String anyContents;
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("anyContents")
		@Override
		public ObjectTypeSequence.ObjectTypeSequenceBuilder setAnyContents(String _anyContents) {
			this.anyContents = _anyContents == null ? null : _anyContents;
			return this;
		}
		
		@Override
		public ObjectTypeSequence build() {
			return new ObjectTypeSequence.ObjectTypeSequenceImpl(this);
		}
		
		@Override
		public ObjectTypeSequence.ObjectTypeSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObjectTypeSequence.ObjectTypeSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAnyContents()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObjectTypeSequence.ObjectTypeSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObjectTypeSequence.ObjectTypeSequenceBuilder o = (ObjectTypeSequence.ObjectTypeSequenceBuilder) other;
			
			
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), this::setAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObjectTypeSequence _that = getType().cast(o);
		
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObjectTypeSequenceBuilder {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
