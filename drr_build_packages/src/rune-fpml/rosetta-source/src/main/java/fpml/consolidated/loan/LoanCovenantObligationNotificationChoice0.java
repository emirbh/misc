package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanCovenantObligationNotificationChoice0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="LoanCovenantObligationNotificationChoice0", builder=LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0BuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationNotificationChoice0", model="fpml", builder=LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0BuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationNotificationChoice0 extends RosettaModelObject {

	LoanCovenantObligationNotificationChoice0Meta metaData = new LoanCovenantObligationNotificationChoice0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A deal identifier structure.
	 *
	 */
	DealIdentifier getDealIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A deal summary structure.
	 *
	 */
	DealSummary getDealSummary();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationNotificationChoice0 build();
	
	LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder toBuilder();
	
	static LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder builder() {
		return new LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationNotificationChoice0> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationNotificationChoice0> getType() {
		return LoanCovenantObligationNotificationChoice0.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationNotificationChoice0Builder extends LoanCovenantObligationNotificationChoice0, RosettaModelObjectBuilder {
		DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier();
		@Override
		DealIdentifier.DealIdentifierBuilder getDealIdentifier();
		DealSummary.DealSummaryBuilder getOrCreateDealSummary();
		@Override
		DealSummary.DealSummaryBuilder getDealSummary();
		LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder setDealIdentifier(DealIdentifier dealIdentifier);
		LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder setDealSummary(DealSummary dealSummary);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
		}
		

		LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationNotificationChoice0  ***********************/
	class LoanCovenantObligationNotificationChoice0Impl implements LoanCovenantObligationNotificationChoice0 {
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		
		protected LoanCovenantObligationNotificationChoice0Impl(LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder builder) {
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealIdentifier")
		public DealIdentifier getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealSummary")
		public DealSummary getDealSummary() {
			return dealSummary;
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice0 build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder toBuilder() {
			LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder builder) {
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationNotificationChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationNotificationChoice0 {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationNotificationChoice0  ***********************/
	class LoanCovenantObligationNotificationChoice0BuilderImpl implements LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder {
	
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		
		@Override
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealIdentifier")
		public DealIdentifier.DealIdentifierBuilder getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier() {
			DealIdentifier.DealIdentifierBuilder result;
			if (dealIdentifier!=null) {
				result = dealIdentifier;
			}
			else {
				result = dealIdentifier = DealIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealSummary")
		public DealSummary.DealSummaryBuilder getDealSummary() {
			return dealSummary;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder getOrCreateDealSummary() {
			DealSummary.DealSummaryBuilder result;
			if (dealSummary!=null) {
				result = dealSummary;
			}
			else {
				result = dealSummary = DealSummary.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice0 build() {
			return new LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Impl(this);
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder prune() {
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder o = (LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder) other;
			
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationNotificationChoice0 _that = getType().cast(o);
		
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationNotificationChoice0Builder {" +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary +
			'}';
		}
	}
}
