package cdm.event.common;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.event.common.meta.MarginCallResponseMeta;
import cdm.event.common.metafields.ReferenceWithMetaCollateralPortfolio;
import cdm.legaldocumentation.common.AgreementName;
import cdm.observable.asset.Money;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Represents common attributes required for a Margin Call Response under a legal agreement such as a credit support document or equivalent.
 * @version 6.23.0
 */
@RosettaDataType(value="MarginCallResponse", builder=MarginCallResponse.MarginCallResponseBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MarginCallResponse", model="cdm", builder=MarginCallResponse.MarginCallResponseBuilderImpl.class, version="6.23.0")
public interface MarginCallResponse extends MarginCallBase {

	MarginCallResponseMeta metaData = new MarginCallResponseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the margin call action details, including collateral to be moved and direction.
	 */
	List<? extends MarginCallResponseAction> getMarginCallResponseAction();
	/**
	 * Indicates the response type, such as, is the margin call response a &#39;full&#39; &#39;part&#39; agreement or &#39;dispute&#39;.
	 */
	MarginCallResponseTypeEnum getMarginResponseType();
	/**
	 * Indicates the amount that posting entity agrees to remit in response to margin call (in base currency).
	 */
	Money getAgreedAmountBaseCurrency();

	/*********************** Build Methods  ***********************/
	MarginCallResponse build();
	
	MarginCallResponse.MarginCallResponseBuilder toBuilder();
	
	static MarginCallResponse.MarginCallResponseBuilder builder() {
		return new MarginCallResponse.MarginCallResponseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginCallResponse> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginCallResponse> getType() {
		return MarginCallResponse.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("instructionType"), processor, MarginCallInstructionType.class, getInstructionType());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("partyRole"), processor, PartyRole.class, getPartyRole());
		processRosetta(path.newSubPath("clearingBroker"), processor, Party.class, getClearingBroker());
		processRosetta(path.newSubPath("callIdentifier"), processor, Identifier.class, getCallIdentifier());
		processRosetta(path.newSubPath("callAgreementType"), processor, AgreementName.class, getCallAgreementType());
		processRosetta(path.newSubPath("agreementMinimumTransferAmount"), processor, Money.class, getAgreementMinimumTransferAmount());
		processRosetta(path.newSubPath("agreementThreshold"), processor, Money.class, getAgreementThreshold());
		processRosetta(path.newSubPath("agreementRounding"), processor, Money.class, getAgreementRounding());
		processor.processBasic(path.newSubPath("regMarginType"), RegMarginTypeEnum.class, getRegMarginType(), this);
		processor.processBasic(path.newSubPath("regIMRole"), RegIMRoleEnum.class, getRegIMRole(), this);
		processRosetta(path.newSubPath("baseCurrencyExposure"), processor, MarginCallExposure.class, getBaseCurrencyExposure());
		processRosetta(path.newSubPath("collateralPortfolio"), processor, ReferenceWithMetaCollateralPortfolio.class, getCollateralPortfolio());
		processRosetta(path.newSubPath("independentAmountBalance"), processor, CollateralBalance.class, getIndependentAmountBalance());
		processRosetta(path.newSubPath("marginCallResponseAction"), processor, MarginCallResponseAction.class, getMarginCallResponseAction());
		processor.processBasic(path.newSubPath("marginResponseType"), MarginCallResponseTypeEnum.class, getMarginResponseType(), this);
		processRosetta(path.newSubPath("agreedAmountBaseCurrency"), processor, Money.class, getAgreedAmountBaseCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginCallResponseBuilder extends MarginCallResponse, MarginCallBase.MarginCallBaseBuilder {
		MarginCallResponseAction.MarginCallResponseActionBuilder getOrCreateMarginCallResponseAction(int index);
		@Override
		List<? extends MarginCallResponseAction.MarginCallResponseActionBuilder> getMarginCallResponseAction();
		Money.MoneyBuilder getOrCreateAgreedAmountBaseCurrency();
		@Override
		Money.MoneyBuilder getAgreedAmountBaseCurrency();
		@Override
		MarginCallResponse.MarginCallResponseBuilder setInstructionType(MarginCallInstructionType instructionType);
		@Override
		MarginCallResponse.MarginCallResponseBuilder addParty(Party party);
		@Override
		MarginCallResponse.MarginCallResponseBuilder addParty(Party party, int idx);
		@Override
		MarginCallResponse.MarginCallResponseBuilder addParty(List<? extends Party> party);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setParty(List<? extends Party> party);
		@Override
		MarginCallResponse.MarginCallResponseBuilder addPartyRole(PartyRole partyRole);
		@Override
		MarginCallResponse.MarginCallResponseBuilder addPartyRole(PartyRole partyRole, int idx);
		@Override
		MarginCallResponse.MarginCallResponseBuilder addPartyRole(List<? extends PartyRole> partyRole);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setPartyRole(List<? extends PartyRole> partyRole);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setClearingBroker(Party clearingBroker);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setCallIdentifier(Identifier callIdentifier);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setCallAgreementType(AgreementName callAgreementType);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setAgreementMinimumTransferAmount(Money agreementMinimumTransferAmount);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setAgreementThreshold(Money agreementThreshold);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setAgreementRounding(Money agreementRounding);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setRegMarginType(RegMarginTypeEnum regMarginType);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setRegIMRole(RegIMRoleEnum regIMRole);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setBaseCurrencyExposure(MarginCallExposure baseCurrencyExposure);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setCollateralPortfolio(ReferenceWithMetaCollateralPortfolio collateralPortfolio);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setCollateralPortfolioValue(CollateralPortfolio collateralPortfolio);
		@Override
		MarginCallResponse.MarginCallResponseBuilder setIndependentAmountBalance(CollateralBalance independentAmountBalance);
		MarginCallResponse.MarginCallResponseBuilder addMarginCallResponseAction(MarginCallResponseAction marginCallResponseAction);
		MarginCallResponse.MarginCallResponseBuilder addMarginCallResponseAction(MarginCallResponseAction marginCallResponseAction, int idx);
		MarginCallResponse.MarginCallResponseBuilder addMarginCallResponseAction(List<? extends MarginCallResponseAction> marginCallResponseAction);
		MarginCallResponse.MarginCallResponseBuilder setMarginCallResponseAction(List<? extends MarginCallResponseAction> marginCallResponseAction);
		MarginCallResponse.MarginCallResponseBuilder setMarginResponseType(MarginCallResponseTypeEnum marginResponseType);
		MarginCallResponse.MarginCallResponseBuilder setAgreedAmountBaseCurrency(Money agreedAmountBaseCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("instructionType"), processor, MarginCallInstructionType.MarginCallInstructionTypeBuilder.class, getInstructionType());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("partyRole"), processor, PartyRole.PartyRoleBuilder.class, getPartyRole());
			processRosetta(path.newSubPath("clearingBroker"), processor, Party.PartyBuilder.class, getClearingBroker());
			processRosetta(path.newSubPath("callIdentifier"), processor, Identifier.IdentifierBuilder.class, getCallIdentifier());
			processRosetta(path.newSubPath("callAgreementType"), processor, AgreementName.AgreementNameBuilder.class, getCallAgreementType());
			processRosetta(path.newSubPath("agreementMinimumTransferAmount"), processor, Money.MoneyBuilder.class, getAgreementMinimumTransferAmount());
			processRosetta(path.newSubPath("agreementThreshold"), processor, Money.MoneyBuilder.class, getAgreementThreshold());
			processRosetta(path.newSubPath("agreementRounding"), processor, Money.MoneyBuilder.class, getAgreementRounding());
			processor.processBasic(path.newSubPath("regMarginType"), RegMarginTypeEnum.class, getRegMarginType(), this);
			processor.processBasic(path.newSubPath("regIMRole"), RegIMRoleEnum.class, getRegIMRole(), this);
			processRosetta(path.newSubPath("baseCurrencyExposure"), processor, MarginCallExposure.MarginCallExposureBuilder.class, getBaseCurrencyExposure());
			processRosetta(path.newSubPath("collateralPortfolio"), processor, ReferenceWithMetaCollateralPortfolio.ReferenceWithMetaCollateralPortfolioBuilder.class, getCollateralPortfolio());
			processRosetta(path.newSubPath("independentAmountBalance"), processor, CollateralBalance.CollateralBalanceBuilder.class, getIndependentAmountBalance());
			processRosetta(path.newSubPath("marginCallResponseAction"), processor, MarginCallResponseAction.MarginCallResponseActionBuilder.class, getMarginCallResponseAction());
			processor.processBasic(path.newSubPath("marginResponseType"), MarginCallResponseTypeEnum.class, getMarginResponseType(), this);
			processRosetta(path.newSubPath("agreedAmountBaseCurrency"), processor, Money.MoneyBuilder.class, getAgreedAmountBaseCurrency());
		}
		

		MarginCallResponse.MarginCallResponseBuilder prune();
	}

	/*********************** Immutable Implementation of MarginCallResponse  ***********************/
	class MarginCallResponseImpl extends MarginCallBase.MarginCallBaseImpl implements MarginCallResponse {
		private final List<? extends MarginCallResponseAction> marginCallResponseAction;
		private final MarginCallResponseTypeEnum marginResponseType;
		private final Money agreedAmountBaseCurrency;
		
		protected MarginCallResponseImpl(MarginCallResponse.MarginCallResponseBuilder builder) {
			super(builder);
			this.marginCallResponseAction = ofNullable(builder.getMarginCallResponseAction()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.marginResponseType = builder.getMarginResponseType();
			this.agreedAmountBaseCurrency = ofNullable(builder.getAgreedAmountBaseCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("marginCallResponseAction")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("marginCallResponseAction")
		public List<? extends MarginCallResponseAction> getMarginCallResponseAction() {
			return marginCallResponseAction;
		}
		
		@Override
		@RosettaAttribute("marginResponseType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("marginResponseType")
		public MarginCallResponseTypeEnum getMarginResponseType() {
			return marginResponseType;
		}
		
		@Override
		@RosettaAttribute("agreedAmountBaseCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("agreedAmountBaseCurrency")
		public Money getAgreedAmountBaseCurrency() {
			return agreedAmountBaseCurrency;
		}
		
		@Override
		public MarginCallResponse build() {
			return this;
		}
		
		@Override
		public MarginCallResponse.MarginCallResponseBuilder toBuilder() {
			MarginCallResponse.MarginCallResponseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginCallResponse.MarginCallResponseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMarginCallResponseAction()).ifPresent(builder::setMarginCallResponseAction);
			ofNullable(getMarginResponseType()).ifPresent(builder::setMarginResponseType);
			ofNullable(getAgreedAmountBaseCurrency()).ifPresent(builder::setAgreedAmountBaseCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MarginCallResponse _that = getType().cast(o);
		
			if (!ListEquals.listEquals(marginCallResponseAction, _that.getMarginCallResponseAction())) return false;
			if (!Objects.equals(marginResponseType, _that.getMarginResponseType())) return false;
			if (!Objects.equals(agreedAmountBaseCurrency, _that.getAgreedAmountBaseCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (marginCallResponseAction != null ? marginCallResponseAction.hashCode() : 0);
			_result = 31 * _result + (marginResponseType != null ? marginResponseType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (agreedAmountBaseCurrency != null ? agreedAmountBaseCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginCallResponse {" +
				"marginCallResponseAction=" + this.marginCallResponseAction + ", " +
				"marginResponseType=" + this.marginResponseType + ", " +
				"agreedAmountBaseCurrency=" + this.agreedAmountBaseCurrency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MarginCallResponse  ***********************/
	class MarginCallResponseBuilderImpl extends MarginCallBase.MarginCallBaseBuilderImpl implements MarginCallResponse.MarginCallResponseBuilder {
	
		protected List<MarginCallResponseAction.MarginCallResponseActionBuilder> marginCallResponseAction = new ArrayList<>();
		protected MarginCallResponseTypeEnum marginResponseType;
		protected Money.MoneyBuilder agreedAmountBaseCurrency;
		
		@Override
		@RosettaAttribute("marginCallResponseAction")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("marginCallResponseAction")
		public List<? extends MarginCallResponseAction.MarginCallResponseActionBuilder> getMarginCallResponseAction() {
			return marginCallResponseAction;
		}
		
		@Override
		public MarginCallResponseAction.MarginCallResponseActionBuilder getOrCreateMarginCallResponseAction(int index) {
			if (marginCallResponseAction==null) {
				this.marginCallResponseAction = new ArrayList<>();
			}
			return getIndex(marginCallResponseAction, index, () -> {
						MarginCallResponseAction.MarginCallResponseActionBuilder newMarginCallResponseAction = MarginCallResponseAction.builder();
						return newMarginCallResponseAction;
					});
		}
		
		@Override
		@RosettaAttribute("marginResponseType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("marginResponseType")
		public MarginCallResponseTypeEnum getMarginResponseType() {
			return marginResponseType;
		}
		
		@Override
		@RosettaAttribute("agreedAmountBaseCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("agreedAmountBaseCurrency")
		public Money.MoneyBuilder getAgreedAmountBaseCurrency() {
			return agreedAmountBaseCurrency;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAgreedAmountBaseCurrency() {
			Money.MoneyBuilder result;
			if (agreedAmountBaseCurrency!=null) {
				result = agreedAmountBaseCurrency;
			}
			else {
				result = agreedAmountBaseCurrency = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("instructionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("instructionType")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setInstructionType(MarginCallInstructionType _instructionType) {
			this.instructionType = _instructionType == null ? null : _instructionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public MarginCallResponse.MarginCallResponseBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public MarginCallResponse.MarginCallResponseBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("party")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("partyRole")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyRole")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder addPartyRole(PartyRole _partyRole) {
			if (_partyRole != null) {
				this.partyRole.add(_partyRole.toBuilder());
			}
			return this;
		}
		
		@Override
		public MarginCallResponse.MarginCallResponseBuilder addPartyRole(PartyRole _partyRole, int idx) {
			getIndex(this.partyRole, idx, () -> _partyRole.toBuilder());
			return this;
		}
		
		@Override
		public MarginCallResponse.MarginCallResponseBuilder addPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles != null) {
				for (final PartyRole toAdd : partyRoles) {
					this.partyRole.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyRole")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyRole")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setPartyRole(List<? extends PartyRole> partyRoles) {
			if (partyRoles == null) {
				this.partyRole = new ArrayList<>();
			} else {
				this.partyRole = partyRoles.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingBroker")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingBroker")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setClearingBroker(Party _clearingBroker) {
			this.clearingBroker = _clearingBroker == null ? null : _clearingBroker.toBuilder();
			return this;
		}
		
		@RosettaAttribute("callIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callIdentifier")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setCallIdentifier(Identifier _callIdentifier) {
			this.callIdentifier = _callIdentifier == null ? null : _callIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("callAgreementType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("callAgreementType")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setCallAgreementType(AgreementName _callAgreementType) {
			this.callAgreementType = _callAgreementType == null ? null : _callAgreementType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agreementMinimumTransferAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementMinimumTransferAmount")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setAgreementMinimumTransferAmount(Money _agreementMinimumTransferAmount) {
			this.agreementMinimumTransferAmount = _agreementMinimumTransferAmount == null ? null : _agreementMinimumTransferAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agreementThreshold")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementThreshold")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setAgreementThreshold(Money _agreementThreshold) {
			this.agreementThreshold = _agreementThreshold == null ? null : _agreementThreshold.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agreementRounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementRounding")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setAgreementRounding(Money _agreementRounding) {
			this.agreementRounding = _agreementRounding == null ? null : _agreementRounding.toBuilder();
			return this;
		}
		
		@RosettaAttribute("regMarginType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("regMarginType")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setRegMarginType(RegMarginTypeEnum _regMarginType) {
			this.regMarginType = _regMarginType == null ? null : _regMarginType;
			return this;
		}
		
		@RosettaAttribute("regIMRole")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("regIMRole")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setRegIMRole(RegIMRoleEnum _regIMRole) {
			this.regIMRole = _regIMRole == null ? null : _regIMRole;
			return this;
		}
		
		@RosettaAttribute("baseCurrencyExposure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseCurrencyExposure")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setBaseCurrencyExposure(MarginCallExposure _baseCurrencyExposure) {
			this.baseCurrencyExposure = _baseCurrencyExposure == null ? null : _baseCurrencyExposure.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralPortfolio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolio")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setCollateralPortfolio(ReferenceWithMetaCollateralPortfolio _collateralPortfolio) {
			this.collateralPortfolio = _collateralPortfolio == null ? null : _collateralPortfolio.toBuilder();
			return this;
		}
		
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setCollateralPortfolioValue(CollateralPortfolio _collateralPortfolio) {
			this.getOrCreateCollateralPortfolio().setValue(_collateralPortfolio);
			return this;
		}
		
		@RosettaAttribute("independentAmountBalance")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("independentAmountBalance")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setIndependentAmountBalance(CollateralBalance _independentAmountBalance) {
			this.independentAmountBalance = _independentAmountBalance == null ? null : _independentAmountBalance.toBuilder();
			return this;
		}
		
		@RosettaAttribute("marginCallResponseAction")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("marginCallResponseAction")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder addMarginCallResponseAction(MarginCallResponseAction _marginCallResponseAction) {
			if (_marginCallResponseAction != null) {
				this.marginCallResponseAction.add(_marginCallResponseAction.toBuilder());
			}
			return this;
		}
		
		@Override
		public MarginCallResponse.MarginCallResponseBuilder addMarginCallResponseAction(MarginCallResponseAction _marginCallResponseAction, int idx) {
			getIndex(this.marginCallResponseAction, idx, () -> _marginCallResponseAction.toBuilder());
			return this;
		}
		
		@Override
		public MarginCallResponse.MarginCallResponseBuilder addMarginCallResponseAction(List<? extends MarginCallResponseAction> marginCallResponseActions) {
			if (marginCallResponseActions != null) {
				for (final MarginCallResponseAction toAdd : marginCallResponseActions) {
					this.marginCallResponseAction.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("marginCallResponseAction")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("marginCallResponseAction")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setMarginCallResponseAction(List<? extends MarginCallResponseAction> marginCallResponseActions) {
			if (marginCallResponseActions == null) {
				this.marginCallResponseAction = new ArrayList<>();
			} else {
				this.marginCallResponseAction = marginCallResponseActions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("marginResponseType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("marginResponseType")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setMarginResponseType(MarginCallResponseTypeEnum _marginResponseType) {
			this.marginResponseType = _marginResponseType == null ? null : _marginResponseType;
			return this;
		}
		
		@RosettaAttribute("agreedAmountBaseCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("agreedAmountBaseCurrency")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder setAgreedAmountBaseCurrency(Money _agreedAmountBaseCurrency) {
			this.agreedAmountBaseCurrency = _agreedAmountBaseCurrency == null ? null : _agreedAmountBaseCurrency.toBuilder();
			return this;
		}
		
		@Override
		public MarginCallResponse build() {
			return new MarginCallResponse.MarginCallResponseImpl(this);
		}
		
		@Override
		public MarginCallResponse.MarginCallResponseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder prune() {
			super.prune();
			marginCallResponseAction = marginCallResponseAction.stream().filter(b->b!=null).<MarginCallResponseAction.MarginCallResponseActionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (agreedAmountBaseCurrency!=null && !agreedAmountBaseCurrency.prune().hasData()) agreedAmountBaseCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMarginCallResponseAction()!=null && getMarginCallResponseAction().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMarginResponseType()!=null) return true;
			if (getAgreedAmountBaseCurrency()!=null && getAgreedAmountBaseCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginCallResponse.MarginCallResponseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MarginCallResponse.MarginCallResponseBuilder o = (MarginCallResponse.MarginCallResponseBuilder) other;
			
			merger.mergeRosetta(getMarginCallResponseAction(), o.getMarginCallResponseAction(), this::getOrCreateMarginCallResponseAction);
			merger.mergeRosetta(getAgreedAmountBaseCurrency(), o.getAgreedAmountBaseCurrency(), this::setAgreedAmountBaseCurrency);
			
			merger.mergeBasic(getMarginResponseType(), o.getMarginResponseType(), this::setMarginResponseType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MarginCallResponse _that = getType().cast(o);
		
			if (!ListEquals.listEquals(marginCallResponseAction, _that.getMarginCallResponseAction())) return false;
			if (!Objects.equals(marginResponseType, _that.getMarginResponseType())) return false;
			if (!Objects.equals(agreedAmountBaseCurrency, _that.getAgreedAmountBaseCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (marginCallResponseAction != null ? marginCallResponseAction.hashCode() : 0);
			_result = 31 * _result + (marginResponseType != null ? marginResponseType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (agreedAmountBaseCurrency != null ? agreedAmountBaseCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginCallResponseBuilder {" +
				"marginCallResponseAction=" + this.marginCallResponseAction + ", " +
				"marginResponseType=" + this.marginResponseType + ", " +
				"agreedAmountBaseCurrency=" + this.agreedAmountBaseCurrency +
			'}' + " " + super.toString();
		}
	}
}
