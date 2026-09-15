package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.SensitivitySetDefinitionReferenceMeta;
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
 * Provision A reference to a sensitivity set definition.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A reference to a sensitivity set definition.
 *
 */
@RosettaDataType(value="SensitivitySetDefinitionReference", builder=SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SensitivitySetDefinitionReference", model="fpml", builder=SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilderImpl.class, version="2.1.1")
public interface SensitivitySetDefinitionReference extends Reference {

	SensitivitySetDefinitionReferenceMeta metaData = new SensitivitySetDefinitionReferenceMeta();

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
	SensitivitySetDefinitionReference build();
	
	SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder toBuilder();
	
	static SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder builder() {
		return new SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivitySetDefinitionReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SensitivitySetDefinitionReference> getType() {
		return SensitivitySetDefinitionReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivitySetDefinitionReferenceBuilder extends SensitivitySetDefinitionReference, Reference.ReferenceBuilder {
		SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivitySetDefinitionReference  ***********************/
	class SensitivitySetDefinitionReferenceImpl extends Reference.ReferenceImpl implements SensitivitySetDefinitionReference {
		private final String href;
		
		protected SensitivitySetDefinitionReferenceImpl(SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder builder) {
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
		public SensitivitySetDefinitionReference build() {
			return this;
		}
		
		@Override
		public SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder toBuilder() {
			SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SensitivitySetDefinitionReference _that = getType().cast(o);
		
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
			return "SensitivitySetDefinitionReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SensitivitySetDefinitionReference  ***********************/
	class SensitivitySetDefinitionReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder {
	
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
		public SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public SensitivitySetDefinitionReference build() {
			return new SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceImpl(this);
		}
		
		@Override
		public SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder prune() {
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
		public SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder o = (SensitivitySetDefinitionReference.SensitivitySetDefinitionReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SensitivitySetDefinitionReference _that = getType().cast(o);
		
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
			return "SensitivitySetDefinitionReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
