package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.ReferenceMeta;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The abstract base class for all types which define intra-document pointers.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The abstract base class for all types which define intra-document pointers.
 *
 */
@RosettaDataType(value="Reference", builder=Reference.ReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Reference", model="fpml", builder=Reference.ReferenceBuilderImpl.class, version="2.1.1")
public interface Reference extends RosettaModelObject {

	ReferenceMeta metaData = new ReferenceMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Reference build();
	
	Reference.ReferenceBuilder toBuilder();
	
	static Reference.ReferenceBuilder builder() {
		return new Reference.ReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Reference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Reference> getType() {
		return Reference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceBuilder extends Reference, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		Reference.ReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of Reference  ***********************/
	class ReferenceImpl implements Reference {
		
		protected ReferenceImpl(Reference.ReferenceBuilder builder) {
		}
		
		@Override
		public Reference build() {
			return this;
		}
		
		@Override
		public Reference.ReferenceBuilder toBuilder() {
			Reference.ReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Reference.ReferenceBuilder builder) {
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "Reference {" +
			'}';
		}
	}

	/*********************** Builder Implementation of Reference  ***********************/
	class ReferenceBuilderImpl implements Reference.ReferenceBuilder {
	
		
		@Override
		public Reference build() {
			return new Reference.ReferenceImpl(this);
		}
		
		@Override
		public Reference.ReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reference.ReferenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reference.ReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Reference.ReferenceBuilder o = (Reference.ReferenceBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceBuilder {" +
			'}';
		}
	}
}
