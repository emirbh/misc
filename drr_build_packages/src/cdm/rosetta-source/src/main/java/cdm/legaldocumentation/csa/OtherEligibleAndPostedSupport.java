package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.OtherEligibleAndPostedSupportMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Other Eligible Support elections associated Initial and Variation margin agreements.
 * @version 6.23.0
 */
@RosettaDataType(value="OtherEligibleAndPostedSupport", builder=OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilderImpl.class, version="6.23.0")
@RuneDataType(value="OtherEligibleAndPostedSupport", model="cdm", builder=OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilderImpl.class, version="6.23.0")
public interface OtherEligibleAndPostedSupport extends RosettaModelObject {

	OtherEligibleAndPostedSupportMeta metaData = new OtherEligibleAndPostedSupportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The definition of &#39;Value&#39; with respect to Other Eligible Support (IM) and Other Posted Support (IM).
	 */
	Boolean getApplicableValue();
	/**
	 * The definition of &#39;Transfer&#39; with respect to Other Eligible Support (IM) and Other Posted Support (IM).
	 */
	Boolean getApplicableTransfer();

	/*********************** Build Methods  ***********************/
	OtherEligibleAndPostedSupport build();
	
	OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder toBuilder();
	
	static OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder builder() {
		return new OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherEligibleAndPostedSupport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OtherEligibleAndPostedSupport> getType() {
		return OtherEligibleAndPostedSupport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicableValue"), Boolean.class, getApplicableValue(), this);
		processor.processBasic(path.newSubPath("applicableTransfer"), Boolean.class, getApplicableTransfer(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherEligibleAndPostedSupportBuilder extends OtherEligibleAndPostedSupport, RosettaModelObjectBuilder {
		OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder setApplicableValue(Boolean applicableValue);
		OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder setApplicableTransfer(Boolean applicableTransfer);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicableValue"), Boolean.class, getApplicableValue(), this);
			processor.processBasic(path.newSubPath("applicableTransfer"), Boolean.class, getApplicableTransfer(), this);
		}
		

		OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder prune();
	}

	/*********************** Immutable Implementation of OtherEligibleAndPostedSupport  ***********************/
	class OtherEligibleAndPostedSupportImpl implements OtherEligibleAndPostedSupport {
		private final Boolean applicableValue;
		private final Boolean applicableTransfer;
		
		protected OtherEligibleAndPostedSupportImpl(OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder builder) {
			this.applicableValue = builder.getApplicableValue();
			this.applicableTransfer = builder.getApplicableTransfer();
		}
		
		@Override
		@RosettaAttribute("applicableValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("applicableValue")
		public Boolean getApplicableValue() {
			return applicableValue;
		}
		
		@Override
		@RosettaAttribute("applicableTransfer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableTransfer")
		public Boolean getApplicableTransfer() {
			return applicableTransfer;
		}
		
		@Override
		public OtherEligibleAndPostedSupport build() {
			return this;
		}
		
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder toBuilder() {
			OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder builder) {
			ofNullable(getApplicableValue()).ifPresent(builder::setApplicableValue);
			ofNullable(getApplicableTransfer()).ifPresent(builder::setApplicableTransfer);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherEligibleAndPostedSupport _that = getType().cast(o);
		
			if (!Objects.equals(applicableValue, _that.getApplicableValue())) return false;
			if (!Objects.equals(applicableTransfer, _that.getApplicableTransfer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableValue != null ? applicableValue.hashCode() : 0);
			_result = 31 * _result + (applicableTransfer != null ? applicableTransfer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherEligibleAndPostedSupport {" +
				"applicableValue=" + this.applicableValue + ", " +
				"applicableTransfer=" + this.applicableTransfer +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherEligibleAndPostedSupport  ***********************/
	class OtherEligibleAndPostedSupportBuilderImpl implements OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder {
	
		protected Boolean applicableValue;
		protected Boolean applicableTransfer;
		
		@Override
		@RosettaAttribute("applicableValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("applicableValue")
		public Boolean getApplicableValue() {
			return applicableValue;
		}
		
		@Override
		@RosettaAttribute("applicableTransfer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableTransfer")
		public Boolean getApplicableTransfer() {
			return applicableTransfer;
		}
		
		@RosettaAttribute("applicableValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("applicableValue")
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder setApplicableValue(Boolean _applicableValue) {
			this.applicableValue = _applicableValue == null ? null : _applicableValue;
			return this;
		}
		
		@RosettaAttribute("applicableTransfer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicableTransfer")
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder setApplicableTransfer(Boolean _applicableTransfer) {
			this.applicableTransfer = _applicableTransfer == null ? null : _applicableTransfer;
			return this;
		}
		
		@Override
		public OtherEligibleAndPostedSupport build() {
			return new OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportImpl(this);
		}
		
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicableValue()!=null) return true;
			if (getApplicableTransfer()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder o = (OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder) other;
			
			
			merger.mergeBasic(getApplicableValue(), o.getApplicableValue(), this::setApplicableValue);
			merger.mergeBasic(getApplicableTransfer(), o.getApplicableTransfer(), this::setApplicableTransfer);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherEligibleAndPostedSupport _that = getType().cast(o);
		
			if (!Objects.equals(applicableValue, _that.getApplicableValue())) return false;
			if (!Objects.equals(applicableTransfer, _that.getApplicableTransfer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableValue != null ? applicableValue.hashCode() : 0);
			_result = 31 * _result + (applicableTransfer != null ? applicableTransfer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherEligibleAndPostedSupportBuilder {" +
				"applicableValue=" + this.applicableValue + ", " +
				"applicableTransfer=" + this.applicableTransfer +
			'}';
		}
	}
}
