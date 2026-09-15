package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.UnprocessedElementWrapperMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type holding a structure that is unvalidated
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type holding a structure that is unvalidated
 *
 */
@RosettaDataType(value="UnprocessedElementWrapper", builder=UnprocessedElementWrapper.UnprocessedElementWrapperBuilderImpl.class, version="2.1.1")
@RuneDataType(value="UnprocessedElementWrapper", model="fpml", builder=UnprocessedElementWrapper.UnprocessedElementWrapperBuilderImpl.class, version="2.1.1")
public interface UnprocessedElementWrapper extends RosettaModelObject {

	UnprocessedElementWrapperMeta metaData = new UnprocessedElementWrapperMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##any; Process Contents: skip.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##any; Process Contents: skip.
	 *
	 */
	String getAnyContents();

	/*********************** Build Methods  ***********************/
	UnprocessedElementWrapper build();
	
	UnprocessedElementWrapper.UnprocessedElementWrapperBuilder toBuilder();
	
	static UnprocessedElementWrapper.UnprocessedElementWrapperBuilder builder() {
		return new UnprocessedElementWrapper.UnprocessedElementWrapperBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnprocessedElementWrapper> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UnprocessedElementWrapper> getType() {
		return UnprocessedElementWrapper.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnprocessedElementWrapperBuilder extends UnprocessedElementWrapper, RosettaModelObjectBuilder {
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder setAnyContents(String anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder prune();
	}

	/*********************** Immutable Implementation of UnprocessedElementWrapper  ***********************/
	class UnprocessedElementWrapperImpl implements UnprocessedElementWrapper {
		private final String anyContents;
		
		protected UnprocessedElementWrapperImpl(UnprocessedElementWrapper.UnprocessedElementWrapperBuilder builder) {
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
		public UnprocessedElementWrapper build() {
			return this;
		}
		
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder toBuilder() {
			UnprocessedElementWrapper.UnprocessedElementWrapperBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnprocessedElementWrapper.UnprocessedElementWrapperBuilder builder) {
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnprocessedElementWrapper _that = getType().cast(o);
		
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
			return "UnprocessedElementWrapper {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of UnprocessedElementWrapper  ***********************/
	class UnprocessedElementWrapperBuilderImpl implements UnprocessedElementWrapper.UnprocessedElementWrapperBuilder {
	
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
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder setAnyContents(String _anyContents) {
			this.anyContents = _anyContents == null ? null : _anyContents;
			return this;
		}
		
		@Override
		public UnprocessedElementWrapper build() {
			return new UnprocessedElementWrapper.UnprocessedElementWrapperImpl(this);
		}
		
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAnyContents()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnprocessedElementWrapper.UnprocessedElementWrapperBuilder o = (UnprocessedElementWrapper.UnprocessedElementWrapperBuilder) other;
			
			
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), this::setAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnprocessedElementWrapper _that = getType().cast(o);
		
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
			return "UnprocessedElementWrapperBuilder {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
