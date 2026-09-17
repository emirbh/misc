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
import fpml.consolidated.com.meta.SettlementPeriodsReferenceMeta;
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
 * Provision Allows a set of Settlement Periods to reference one already defined elsewhere in the trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Allows a set of Settlement Periods to reference one already defined elsewhere in the trade.
 *
 */
@RosettaDataType(value="SettlementPeriodsReference", builder=SettlementPeriodsReference.SettlementPeriodsReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementPeriodsReference", model="fpml", builder=SettlementPeriodsReference.SettlementPeriodsReferenceBuilderImpl.class, version="2.1.1")
public interface SettlementPeriodsReference extends Reference {

	SettlementPeriodsReferenceMeta metaData = new SettlementPeriodsReferenceMeta();

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
	SettlementPeriodsReference build();
	
	SettlementPeriodsReference.SettlementPeriodsReferenceBuilder toBuilder();
	
	static SettlementPeriodsReference.SettlementPeriodsReferenceBuilder builder() {
		return new SettlementPeriodsReference.SettlementPeriodsReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodsReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementPeriodsReference> getType() {
		return SettlementPeriodsReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodsReferenceBuilder extends SettlementPeriodsReference, Reference.ReferenceBuilder {
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodsReference  ***********************/
	class SettlementPeriodsReferenceImpl extends Reference.ReferenceImpl implements SettlementPeriodsReference {
		private final String href;
		
		protected SettlementPeriodsReferenceImpl(SettlementPeriodsReference.SettlementPeriodsReferenceBuilder builder) {
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
		public SettlementPeriodsReference build() {
			return this;
		}
		
		@Override
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder toBuilder() {
			SettlementPeriodsReference.SettlementPeriodsReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodsReference.SettlementPeriodsReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementPeriodsReference _that = getType().cast(o);
		
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
			return "SettlementPeriodsReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SettlementPeriodsReference  ***********************/
	class SettlementPeriodsReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements SettlementPeriodsReference.SettlementPeriodsReferenceBuilder {
	
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
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public SettlementPeriodsReference build() {
			return new SettlementPeriodsReference.SettlementPeriodsReferenceImpl(this);
		}
		
		@Override
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder prune() {
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
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SettlementPeriodsReference.SettlementPeriodsReferenceBuilder o = (SettlementPeriodsReference.SettlementPeriodsReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementPeriodsReference _that = getType().cast(o);
		
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
			return "SettlementPeriodsReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
