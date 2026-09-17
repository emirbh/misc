package fpml.consolidated.business.events;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.business.events.meta.CreditLimitInformationMeta;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.fpmlenum.LimitModelEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
@RosettaDataType(value="CreditLimitInformation", builder=CreditLimitInformation.CreditLimitInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditLimitInformation", model="fpml", builder=CreditLimitInformation.CreditLimitInformationBuilderImpl.class, version="2.1.1")
public interface CreditLimitInformation extends RosettaModelObject {

	CreditLimitInformationMeta metaData = new CreditLimitInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	PartyTradeInformation getPartyInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LimitModelEnum getLimitModel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends CreditLimit> getCreditLimit();

	/*********************** Build Methods  ***********************/
	CreditLimitInformation build();
	
	CreditLimitInformation.CreditLimitInformationBuilder toBuilder();
	
	static CreditLimitInformation.CreditLimitInformationBuilder builder() {
		return new CreditLimitInformation.CreditLimitInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimitInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditLimitInformation> getType() {
		return CreditLimitInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyInformation"), processor, PartyTradeInformation.class, getPartyInformation());
		processor.processBasic(path.newSubPath("limitModel"), LimitModelEnum.class, getLimitModel(), this);
		processRosetta(path.newSubPath("creditLimit"), processor, CreditLimit.class, getCreditLimit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitInformationBuilder extends CreditLimitInformation, RosettaModelObjectBuilder {
		PartyTradeInformation.PartyTradeInformationBuilder getOrCreatePartyInformation();
		@Override
		PartyTradeInformation.PartyTradeInformationBuilder getPartyInformation();
		CreditLimit.CreditLimitBuilder getOrCreateCreditLimit(int index);
		@Override
		List<? extends CreditLimit.CreditLimitBuilder> getCreditLimit();
		CreditLimitInformation.CreditLimitInformationBuilder setPartyInformation(PartyTradeInformation partyInformation);
		CreditLimitInformation.CreditLimitInformationBuilder setLimitModel(LimitModelEnum limitModel);
		CreditLimitInformation.CreditLimitInformationBuilder addCreditLimit(CreditLimit creditLimit);
		CreditLimitInformation.CreditLimitInformationBuilder addCreditLimit(CreditLimit creditLimit, int idx);
		CreditLimitInformation.CreditLimitInformationBuilder addCreditLimit(List<? extends CreditLimit> creditLimit);
		CreditLimitInformation.CreditLimitInformationBuilder setCreditLimit(List<? extends CreditLimit> creditLimit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyInformation"), processor, PartyTradeInformation.PartyTradeInformationBuilder.class, getPartyInformation());
			processor.processBasic(path.newSubPath("limitModel"), LimitModelEnum.class, getLimitModel(), this);
			processRosetta(path.newSubPath("creditLimit"), processor, CreditLimit.CreditLimitBuilder.class, getCreditLimit());
		}
		

		CreditLimitInformation.CreditLimitInformationBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimitInformation  ***********************/
	class CreditLimitInformationImpl implements CreditLimitInformation {
		private final PartyTradeInformation partyInformation;
		private final LimitModelEnum limitModel;
		private final List<? extends CreditLimit> creditLimit;
		
		protected CreditLimitInformationImpl(CreditLimitInformation.CreditLimitInformationBuilder builder) {
			this.partyInformation = ofNullable(builder.getPartyInformation()).map(f->f.build()).orElse(null);
			this.limitModel = builder.getLimitModel();
			this.creditLimit = ofNullable(builder.getCreditLimit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyInformation")
		public PartyTradeInformation getPartyInformation() {
			return partyInformation;
		}
		
		@Override
		@RosettaAttribute("limitModel")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("limitModel")
		public LimitModelEnum getLimitModel() {
			return limitModel;
		}
		
		@Override
		@RosettaAttribute("creditLimit")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("creditLimit")
		public List<? extends CreditLimit> getCreditLimit() {
			return creditLimit;
		}
		
		@Override
		public CreditLimitInformation build() {
			return this;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder toBuilder() {
			CreditLimitInformation.CreditLimitInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitInformation.CreditLimitInformationBuilder builder) {
			ofNullable(getPartyInformation()).ifPresent(builder::setPartyInformation);
			ofNullable(getLimitModel()).ifPresent(builder::setLimitModel);
			ofNullable(getCreditLimit()).ifPresent(builder::setCreditLimit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyInformation, _that.getPartyInformation())) return false;
			if (!Objects.equals(limitModel, _that.getLimitModel())) return false;
			if (!ListEquals.listEquals(creditLimit, _that.getCreditLimit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyInformation != null ? partyInformation.hashCode() : 0);
			_result = 31 * _result + (limitModel != null ? limitModel.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditLimit != null ? creditLimit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitInformation {" +
				"partyInformation=" + this.partyInformation + ", " +
				"limitModel=" + this.limitModel + ", " +
				"creditLimit=" + this.creditLimit +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditLimitInformation  ***********************/
	class CreditLimitInformationBuilderImpl implements CreditLimitInformation.CreditLimitInformationBuilder {
	
		protected PartyTradeInformation.PartyTradeInformationBuilder partyInformation;
		protected LimitModelEnum limitModel;
		protected List<CreditLimit.CreditLimitBuilder> creditLimit = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyInformation")
		public PartyTradeInformation.PartyTradeInformationBuilder getPartyInformation() {
			return partyInformation;
		}
		
		@Override
		public PartyTradeInformation.PartyTradeInformationBuilder getOrCreatePartyInformation() {
			PartyTradeInformation.PartyTradeInformationBuilder result;
			if (partyInformation!=null) {
				result = partyInformation;
			}
			else {
				result = partyInformation = PartyTradeInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("limitModel")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("limitModel")
		public LimitModelEnum getLimitModel() {
			return limitModel;
		}
		
		@Override
		@RosettaAttribute("creditLimit")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("creditLimit")
		public List<? extends CreditLimit.CreditLimitBuilder> getCreditLimit() {
			return creditLimit;
		}
		
		@Override
		public CreditLimit.CreditLimitBuilder getOrCreateCreditLimit(int index) {
			if (creditLimit==null) {
				this.creditLimit = new ArrayList<>();
			}
			return getIndex(creditLimit, index, () -> {
						CreditLimit.CreditLimitBuilder newCreditLimit = CreditLimit.builder();
						return newCreditLimit;
					});
		}
		
		@RosettaAttribute("partyInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyInformation")
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder setPartyInformation(PartyTradeInformation _partyInformation) {
			this.partyInformation = _partyInformation == null ? null : _partyInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("limitModel")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("limitModel")
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder setLimitModel(LimitModelEnum _limitModel) {
			this.limitModel = _limitModel == null ? null : _limitModel;
			return this;
		}
		
		@RosettaAttribute("creditLimit")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("creditLimit")
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder addCreditLimit(CreditLimit _creditLimit) {
			if (_creditLimit != null) {
				this.creditLimit.add(_creditLimit.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder addCreditLimit(CreditLimit _creditLimit, int idx) {
			getIndex(this.creditLimit, idx, () -> _creditLimit.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder addCreditLimit(List<? extends CreditLimit> creditLimits) {
			if (creditLimits != null) {
				for (final CreditLimit toAdd : creditLimits) {
					this.creditLimit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditLimit")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("creditLimit")
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder setCreditLimit(List<? extends CreditLimit> creditLimits) {
			if (creditLimits == null) {
				this.creditLimit = new ArrayList<>();
			} else {
				this.creditLimit = creditLimits.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditLimitInformation build() {
			return new CreditLimitInformation.CreditLimitInformationImpl(this);
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder prune() {
			if (partyInformation!=null && !partyInformation.prune().hasData()) partyInformation = null;
			creditLimit = creditLimit.stream().filter(b->b!=null).<CreditLimit.CreditLimitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyInformation()!=null && getPartyInformation().hasData()) return true;
			if (getLimitModel()!=null) return true;
			if (getCreditLimit()!=null && getCreditLimit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitInformation.CreditLimitInformationBuilder o = (CreditLimitInformation.CreditLimitInformationBuilder) other;
			
			merger.mergeRosetta(getPartyInformation(), o.getPartyInformation(), this::setPartyInformation);
			merger.mergeRosetta(getCreditLimit(), o.getCreditLimit(), this::getOrCreateCreditLimit);
			
			merger.mergeBasic(getLimitModel(), o.getLimitModel(), this::setLimitModel);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyInformation, _that.getPartyInformation())) return false;
			if (!Objects.equals(limitModel, _that.getLimitModel())) return false;
			if (!ListEquals.listEquals(creditLimit, _that.getCreditLimit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyInformation != null ? partyInformation.hashCode() : 0);
			_result = 31 * _result + (limitModel != null ? limitModel.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditLimit != null ? creditLimit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitInformationBuilder {" +
				"partyInformation=" + this.partyInformation + ", " +
				"limitModel=" + this.limitModel + ", " +
				"creditLimit=" + this.creditLimit +
			'}';
		}
	}
}
