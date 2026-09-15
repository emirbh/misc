package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.RelevantUnderlyingDateReferenceMeta;
import fpml.consolidated.shared.Reference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Reference to relevant underlying date.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Reference to relevant underlying date.
 *
 */
@RosettaDataType(value="RelevantUnderlyingDateReference", builder=RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RelevantUnderlyingDateReference", model="fpml", builder=RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilderImpl.class, version="2.1.1")
public interface RelevantUnderlyingDateReference extends Reference {

	RelevantUnderlyingDateReferenceMeta metaData = new RelevantUnderlyingDateReferenceMeta();

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
	RelevantUnderlyingDateReference build();
	
	RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder toBuilder();
	
	static RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder builder() {
		return new RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelevantUnderlyingDateReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RelevantUnderlyingDateReference> getType() {
		return RelevantUnderlyingDateReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelevantUnderlyingDateReferenceBuilder extends RelevantUnderlyingDateReference, Reference.ReferenceBuilder {
		RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of RelevantUnderlyingDateReference  ***********************/
	class RelevantUnderlyingDateReferenceImpl extends Reference.ReferenceImpl implements RelevantUnderlyingDateReference {
		private final String href;
		
		protected RelevantUnderlyingDateReferenceImpl(RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder builder) {
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
		public RelevantUnderlyingDateReference build() {
			return this;
		}
		
		@Override
		public RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder toBuilder() {
			RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelevantUnderlyingDateReference _that = getType().cast(o);
		
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
			return "RelevantUnderlyingDateReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RelevantUnderlyingDateReference  ***********************/
	class RelevantUnderlyingDateReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder {
	
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
		public RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public RelevantUnderlyingDateReference build() {
			return new RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceImpl(this);
		}
		
		@Override
		public RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder prune() {
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
		public RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder o = (RelevantUnderlyingDateReference.RelevantUnderlyingDateReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RelevantUnderlyingDateReference _that = getType().cast(o);
		
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
			return "RelevantUnderlyingDateReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
