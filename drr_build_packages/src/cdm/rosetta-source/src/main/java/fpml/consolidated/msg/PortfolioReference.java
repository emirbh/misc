package fpml.consolidated.msg;

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
import fpml.consolidated.doc.PortfolioName;
import fpml.consolidated.msg.meta.PortfolioReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to group together individual messages that can be acted on at a group level.
 *
 */
@RosettaDataType(value="PortfolioReference", builder=PortfolioReference.PortfolioReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PortfolioReference", model="fpml", builder=PortfolioReference.PortfolioReferenceBuilderImpl.class, version="2.1.1")
public interface PortfolioReference extends PortfolioReferenceBase {

	PortfolioReferenceMeta metaData = new PortfolioReferenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A numeric, sequentially ascending (i.e. gapless) value (starting at 1) that can be used to identify and distinguish the individual constituents of a portfolio request. A recipient should ensure that all sequence numbers from 1 to the final sequence number (where submissionsComplete is true) have arrived before completing the portfolio request.
	 *
	 */
	Integer getSequenceNumber();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether all individual requests have been submitted for this portfolio request.
	 *
	 */
	Boolean getSubmissionsComplete();

	/*********************** Build Methods  ***********************/
	PortfolioReference build();
	
	PortfolioReference.PortfolioReferenceBuilder toBuilder();
	
	static PortfolioReference.PortfolioReferenceBuilder builder() {
		return new PortfolioReference.PortfolioReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PortfolioReference> getType() {
		return PortfolioReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("portfolioName"), processor, PortfolioName.class, getPortfolioName());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processor.processBasic(path.newSubPath("submissionsComplete"), Boolean.class, getSubmissionsComplete(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioReferenceBuilder extends PortfolioReference, PortfolioReferenceBase.PortfolioReferenceBaseBuilder {
		@Override
		PortfolioReference.PortfolioReferenceBuilder setPortfolioName(PortfolioName portfolioName);
		PortfolioReference.PortfolioReferenceBuilder setSequenceNumber(Integer sequenceNumber);
		PortfolioReference.PortfolioReferenceBuilder setSubmissionsComplete(Boolean submissionsComplete);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("portfolioName"), processor, PortfolioName.PortfolioNameBuilder.class, getPortfolioName());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processor.processBasic(path.newSubPath("submissionsComplete"), Boolean.class, getSubmissionsComplete(), this);
		}
		

		PortfolioReference.PortfolioReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioReference  ***********************/
	class PortfolioReferenceImpl extends PortfolioReferenceBase.PortfolioReferenceBaseImpl implements PortfolioReference {
		private final Integer sequenceNumber;
		private final Boolean submissionsComplete;
		
		protected PortfolioReferenceImpl(PortfolioReference.PortfolioReferenceBuilder builder) {
			super(builder);
			this.sequenceNumber = builder.getSequenceNumber();
			this.submissionsComplete = builder.getSubmissionsComplete();
		}
		
		@Override
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sequenceNumber")
		public Integer getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		@RosettaAttribute("submissionsComplete")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submissionsComplete")
		public Boolean getSubmissionsComplete() {
			return submissionsComplete;
		}
		
		@Override
		public PortfolioReference build() {
			return this;
		}
		
		@Override
		public PortfolioReference.PortfolioReferenceBuilder toBuilder() {
			PortfolioReference.PortfolioReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioReference.PortfolioReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSequenceNumber()).ifPresent(builder::setSequenceNumber);
			ofNullable(getSubmissionsComplete()).ifPresent(builder::setSubmissionsComplete);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PortfolioReference _that = getType().cast(o);
		
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!Objects.equals(submissionsComplete, _that.getSubmissionsComplete())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (submissionsComplete != null ? submissionsComplete.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReference {" +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"submissionsComplete=" + this.submissionsComplete +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PortfolioReference  ***********************/
	class PortfolioReferenceBuilderImpl extends PortfolioReferenceBase.PortfolioReferenceBaseBuilderImpl implements PortfolioReference.PortfolioReferenceBuilder {
	
		protected Integer sequenceNumber;
		protected Boolean submissionsComplete;
		
		@Override
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sequenceNumber")
		public Integer getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		@RosettaAttribute("submissionsComplete")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submissionsComplete")
		public Boolean getSubmissionsComplete() {
			return submissionsComplete;
		}
		
		@RosettaAttribute("portfolioName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("portfolioName")
		@Override
		public PortfolioReference.PortfolioReferenceBuilder setPortfolioName(PortfolioName _portfolioName) {
			this.portfolioName = _portfolioName == null ? null : _portfolioName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sequenceNumber")
		@Override
		public PortfolioReference.PortfolioReferenceBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("submissionsComplete")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("submissionsComplete")
		@Override
		public PortfolioReference.PortfolioReferenceBuilder setSubmissionsComplete(Boolean _submissionsComplete) {
			this.submissionsComplete = _submissionsComplete == null ? null : _submissionsComplete;
			return this;
		}
		
		@Override
		public PortfolioReference build() {
			return new PortfolioReference.PortfolioReferenceImpl(this);
		}
		
		@Override
		public PortfolioReference.PortfolioReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReference.PortfolioReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSequenceNumber()!=null) return true;
			if (getSubmissionsComplete()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReference.PortfolioReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PortfolioReference.PortfolioReferenceBuilder o = (PortfolioReference.PortfolioReferenceBuilder) other;
			
			
			merger.mergeBasic(getSequenceNumber(), o.getSequenceNumber(), this::setSequenceNumber);
			merger.mergeBasic(getSubmissionsComplete(), o.getSubmissionsComplete(), this::setSubmissionsComplete);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PortfolioReference _that = getType().cast(o);
		
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			if (!Objects.equals(submissionsComplete, _that.getSubmissionsComplete())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			_result = 31 * _result + (submissionsComplete != null ? submissionsComplete.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReferenceBuilder {" +
				"sequenceNumber=" + this.sequenceNumber + ", " +
				"submissionsComplete=" + this.submissionsComplete +
			'}' + " " + super.toString();
		}
	}
}
