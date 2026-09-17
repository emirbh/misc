package fpml.consolidated.cd;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.cd.meta.LoanParticipationMeta;
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
@RosettaDataType(value="LoanParticipation", builder=LoanParticipation.LoanParticipationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanParticipation", model="fpml", builder=LoanParticipation.LoanParticipationBuilderImpl.class, version="2.1.1")
public interface LoanParticipation extends PCDeliverableObligationCharac {

	LoanParticipationMeta metaData = new LoanParticipationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If Direct Loan Participation is specified as a deliverable obligation characteristic, this specifies any requirements for the Qualifying Participation Seller. The requirements may be listed free-form. ISDA 2003 Term: Qualifying Participation Seller
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If Direct Loan Participation is specified as a deliverable obligation characteristic, this specifies any requirements for the Qualifying Participation Seller. The requirements may be listed free-form. ISDA 2003 Term: Qualifying Participation Seller
	 *
	 */
	String getQualifyingParticipationSeller();

	/*********************** Build Methods  ***********************/
	LoanParticipation build();
	
	LoanParticipation.LoanParticipationBuilder toBuilder();
	
	static LoanParticipation.LoanParticipationBuilder builder() {
		return new LoanParticipation.LoanParticipationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanParticipation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanParticipation> getType() {
		return LoanParticipation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processor.processBasic(path.newSubPath("partialCashSettlement"), Boolean.class, getPartialCashSettlement(), this);
		processor.processBasic(path.newSubPath("qualifyingParticipationSeller"), String.class, getQualifyingParticipationSeller(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanParticipationBuilder extends LoanParticipation, PCDeliverableObligationCharac.PCDeliverableObligationCharacBuilder {
		@Override
		LoanParticipation.LoanParticipationBuilder setApplicable(Boolean applicable);
		@Override
		LoanParticipation.LoanParticipationBuilder setPartialCashSettlement(Boolean partialCashSettlement);
		LoanParticipation.LoanParticipationBuilder setQualifyingParticipationSeller(String qualifyingParticipationSeller);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processor.processBasic(path.newSubPath("partialCashSettlement"), Boolean.class, getPartialCashSettlement(), this);
			processor.processBasic(path.newSubPath("qualifyingParticipationSeller"), String.class, getQualifyingParticipationSeller(), this);
		}
		

		LoanParticipation.LoanParticipationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanParticipation  ***********************/
	class LoanParticipationImpl extends PCDeliverableObligationCharac.PCDeliverableObligationCharacImpl implements LoanParticipation {
		private final String qualifyingParticipationSeller;
		
		protected LoanParticipationImpl(LoanParticipation.LoanParticipationBuilder builder) {
			super(builder);
			this.qualifyingParticipationSeller = builder.getQualifyingParticipationSeller();
		}
		
		@Override
		@RosettaAttribute("qualifyingParticipationSeller")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("qualifyingParticipationSeller")
		public String getQualifyingParticipationSeller() {
			return qualifyingParticipationSeller;
		}
		
		@Override
		public LoanParticipation build() {
			return this;
		}
		
		@Override
		public LoanParticipation.LoanParticipationBuilder toBuilder() {
			LoanParticipation.LoanParticipationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanParticipation.LoanParticipationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQualifyingParticipationSeller()).ifPresent(builder::setQualifyingParticipationSeller);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanParticipation _that = getType().cast(o);
		
			if (!Objects.equals(qualifyingParticipationSeller, _that.getQualifyingParticipationSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (qualifyingParticipationSeller != null ? qualifyingParticipationSeller.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanParticipation {" +
				"qualifyingParticipationSeller=" + this.qualifyingParticipationSeller +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanParticipation  ***********************/
	class LoanParticipationBuilderImpl extends PCDeliverableObligationCharac.PCDeliverableObligationCharacBuilderImpl implements LoanParticipation.LoanParticipationBuilder {
	
		protected String qualifyingParticipationSeller;
		
		@Override
		@RosettaAttribute("qualifyingParticipationSeller")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("qualifyingParticipationSeller")
		public String getQualifyingParticipationSeller() {
			return qualifyingParticipationSeller;
		}
		
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicable")
		@Override
		public LoanParticipation.LoanParticipationBuilder setApplicable(Boolean _applicable) {
			this.applicable = _applicable == null ? null : _applicable;
			return this;
		}
		
		@RosettaAttribute("partialCashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partialCashSettlement")
		@Override
		public LoanParticipation.LoanParticipationBuilder setPartialCashSettlement(Boolean _partialCashSettlement) {
			this.partialCashSettlement = _partialCashSettlement == null ? null : _partialCashSettlement;
			return this;
		}
		
		@RosettaAttribute("qualifyingParticipationSeller")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("qualifyingParticipationSeller")
		@Override
		public LoanParticipation.LoanParticipationBuilder setQualifyingParticipationSeller(String _qualifyingParticipationSeller) {
			this.qualifyingParticipationSeller = _qualifyingParticipationSeller == null ? null : _qualifyingParticipationSeller;
			return this;
		}
		
		@Override
		public LoanParticipation build() {
			return new LoanParticipation.LoanParticipationImpl(this);
		}
		
		@Override
		public LoanParticipation.LoanParticipationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanParticipation.LoanParticipationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQualifyingParticipationSeller()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanParticipation.LoanParticipationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanParticipation.LoanParticipationBuilder o = (LoanParticipation.LoanParticipationBuilder) other;
			
			
			merger.mergeBasic(getQualifyingParticipationSeller(), o.getQualifyingParticipationSeller(), this::setQualifyingParticipationSeller);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanParticipation _that = getType().cast(o);
		
			if (!Objects.equals(qualifyingParticipationSeller, _that.getQualifyingParticipationSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (qualifyingParticipationSeller != null ? qualifyingParticipationSeller.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanParticipationBuilder {" +
				"qualifyingParticipationSeller=" + this.qualifyingParticipationSeller +
			'}' + " " + super.toString();
		}
	}
}
