package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.DeterminationMethodReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A reference to the return swap notional determination method.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A reference to the return swap notional determination method.
 *
 */
@RosettaDataType(value="DeterminationMethodReference", builder=DeterminationMethodReference.DeterminationMethodReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DeterminationMethodReference", model="fpml", builder=DeterminationMethodReference.DeterminationMethodReferenceBuilderImpl.class, version="2.1.1")
public interface DeterminationMethodReference extends Reference {

	DeterminationMethodReferenceMeta metaData = new DeterminationMethodReferenceMeta();

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
	String getHref();

	/*********************** Build Methods  ***********************/
	DeterminationMethodReference build();
	
	DeterminationMethodReference.DeterminationMethodReferenceBuilder toBuilder();
	
	static DeterminationMethodReference.DeterminationMethodReferenceBuilder builder() {
		return new DeterminationMethodReference.DeterminationMethodReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeterminationMethodReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DeterminationMethodReference> getType() {
		return DeterminationMethodReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeterminationMethodReferenceBuilder extends DeterminationMethodReference, Reference.ReferenceBuilder {
		DeterminationMethodReference.DeterminationMethodReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		DeterminationMethodReference.DeterminationMethodReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of DeterminationMethodReference  ***********************/
	class DeterminationMethodReferenceImpl extends Reference.ReferenceImpl implements DeterminationMethodReference {
		private final String href;
		
		protected DeterminationMethodReferenceImpl(DeterminationMethodReference.DeterminationMethodReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public DeterminationMethodReference build() {
			return this;
		}
		
		@Override
		public DeterminationMethodReference.DeterminationMethodReferenceBuilder toBuilder() {
			DeterminationMethodReference.DeterminationMethodReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeterminationMethodReference.DeterminationMethodReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DeterminationMethodReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeterminationMethodReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DeterminationMethodReference  ***********************/
	class DeterminationMethodReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements DeterminationMethodReference.DeterminationMethodReferenceBuilder {
	
		protected String href;
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
		@RosettaAttribute("href")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("href")
		@Override
		public DeterminationMethodReference.DeterminationMethodReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public DeterminationMethodReference build() {
			return new DeterminationMethodReference.DeterminationMethodReferenceImpl(this);
		}
		
		@Override
		public DeterminationMethodReference.DeterminationMethodReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeterminationMethodReference.DeterminationMethodReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeterminationMethodReference.DeterminationMethodReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DeterminationMethodReference.DeterminationMethodReferenceBuilder o = (DeterminationMethodReference.DeterminationMethodReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DeterminationMethodReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeterminationMethodReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
