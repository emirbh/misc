package fpml.consolidated.business.events;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.business.events.meta.WithdrawalMeta;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.doc.Trade;
import java.time.ZonedDateTime;
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
 * version "recordkeeping-5.13"
 *
 * Provision A structure describing the removal of a trade from a service, such as a reporting service.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing the removal of a trade from a service, such as a reporting service.
 *
 */
@RosettaDataType(value="Withdrawal", builder=Withdrawal.WithdrawalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Withdrawal", model="fpml", builder=Withdrawal.WithdrawalBuilderImpl.class, version="2.1.1")
public interface Withdrawal extends RosettaModelObject {

	WithdrawalMeta metaData = new WithdrawalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifiers of the trade that is being withdrawn.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifiers of the trade that is being withdrawn.
	 *
	 */
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Holds party-specific information about the trade that is being withdrawn from.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Holds party-specific information about the trade that is being withdrawn from.
	 *
	 */
	List<? extends WithdrawalPartyTradeInformation> getPartyTradeInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The full trade representation that is being withdrawn.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The full trade representation that is being withdrawn.
	 *
	 */
	Trade getTrade();
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
	ZonedDateTime getEffectiveDate();
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
	RequestedWithdrawalAction getRequestedAction();
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
	List<? extends WithdrawalReason> getReason();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. The supervisor/regulator to which this withdrawal applies
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. The supervisor/regulator to which this withdrawal applies
	 *
	 */
	List<? extends ReportingRegimeIdentifier> getReportingRegime();

	/*********************** Build Methods  ***********************/
	Withdrawal build();
	
	Withdrawal.WithdrawalBuilder toBuilder();
	
	static Withdrawal.WithdrawalBuilder builder() {
		return new Withdrawal.WithdrawalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Withdrawal> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Withdrawal> getType() {
		return Withdrawal.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("partyTradeInformation"), processor, WithdrawalPartyTradeInformation.class, getPartyTradeInformation());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("requestedAction"), processor, RequestedWithdrawalAction.class, getRequestedAction());
		processRosetta(path.newSubPath("reason"), processor, WithdrawalReason.class, getReason());
		processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.class, getReportingRegime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WithdrawalBuilder extends Withdrawal, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder getOrCreatePartyTradeInformation(int index);
		@Override
		List<? extends WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder> getPartyTradeInformation();
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		RequestedWithdrawalAction.RequestedWithdrawalActionBuilder getOrCreateRequestedAction();
		@Override
		RequestedWithdrawalAction.RequestedWithdrawalActionBuilder getRequestedAction();
		WithdrawalReason.WithdrawalReasonBuilder getOrCreateReason(int index);
		@Override
		List<? extends WithdrawalReason.WithdrawalReasonBuilder> getReason();
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int index);
		@Override
		List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime();
		Withdrawal.WithdrawalBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		Withdrawal.WithdrawalBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int idx);
		Withdrawal.WithdrawalBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		Withdrawal.WithdrawalBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		Withdrawal.WithdrawalBuilder addPartyTradeInformation(WithdrawalPartyTradeInformation partyTradeInformation);
		Withdrawal.WithdrawalBuilder addPartyTradeInformation(WithdrawalPartyTradeInformation partyTradeInformation, int idx);
		Withdrawal.WithdrawalBuilder addPartyTradeInformation(List<? extends WithdrawalPartyTradeInformation> partyTradeInformation);
		Withdrawal.WithdrawalBuilder setPartyTradeInformation(List<? extends WithdrawalPartyTradeInformation> partyTradeInformation);
		Withdrawal.WithdrawalBuilder setTrade(Trade trade);
		Withdrawal.WithdrawalBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		Withdrawal.WithdrawalBuilder setRequestedAction(RequestedWithdrawalAction requestedAction);
		Withdrawal.WithdrawalBuilder addReason(WithdrawalReason reason);
		Withdrawal.WithdrawalBuilder addReason(WithdrawalReason reason, int idx);
		Withdrawal.WithdrawalBuilder addReason(List<? extends WithdrawalReason> reason);
		Withdrawal.WithdrawalBuilder setReason(List<? extends WithdrawalReason> reason);
		Withdrawal.WithdrawalBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime);
		Withdrawal.WithdrawalBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime, int idx);
		Withdrawal.WithdrawalBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime);
		Withdrawal.WithdrawalBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("partyTradeInformation"), processor, WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder.class, getPartyTradeInformation());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("requestedAction"), processor, RequestedWithdrawalAction.RequestedWithdrawalActionBuilder.class, getRequestedAction());
			processRosetta(path.newSubPath("reason"), processor, WithdrawalReason.WithdrawalReasonBuilder.class, getReason());
			processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder.class, getReportingRegime());
		}
		

		Withdrawal.WithdrawalBuilder prune();
	}

	/*********************** Immutable Implementation of Withdrawal  ***********************/
	class WithdrawalImpl implements Withdrawal {
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		private final List<? extends WithdrawalPartyTradeInformation> partyTradeInformation;
		private final Trade trade;
		private final ZonedDateTime effectiveDate;
		private final RequestedWithdrawalAction requestedAction;
		private final List<? extends WithdrawalReason> reason;
		private final List<? extends ReportingRegimeIdentifier> reportingRegime;
		
		protected WithdrawalImpl(Withdrawal.WithdrawalBuilder builder) {
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeInformation = ofNullable(builder.getPartyTradeInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.requestedAction = ofNullable(builder.getRequestedAction()).map(f->f.build()).orElse(null);
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingRegime = ofNullable(builder.getReportingRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		public List<? extends WithdrawalPartyTradeInformation> getPartyTradeInformation() {
			return partyTradeInformation;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("requestedAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedAction")
		public RequestedWithdrawalAction getRequestedAction() {
			return requestedAction;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends WithdrawalReason> getReason() {
			return reason;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public Withdrawal build() {
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder toBuilder() {
			Withdrawal.WithdrawalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Withdrawal.WithdrawalBuilder builder) {
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getPartyTradeInformation()).ifPresent(builder::setPartyTradeInformation);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getRequestedAction()).ifPresent(builder::setRequestedAction);
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getReportingRegime()).ifPresent(builder::setReportingRegime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Withdrawal _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(requestedAction, _that.getRequestedAction())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (requestedAction != null ? requestedAction.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Withdrawal {" +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"trade=" + this.trade + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"requestedAction=" + this.requestedAction + ", " +
				"reason=" + this.reason + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}

	/*********************** Builder Implementation of Withdrawal  ***********************/
	class WithdrawalBuilderImpl implements Withdrawal.WithdrawalBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
		protected List<WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder> partyTradeInformation = new ArrayList<>();
		protected Trade.TradeBuilder trade;
		protected ZonedDateTime effectiveDate;
		protected RequestedWithdrawalAction.RequestedWithdrawalActionBuilder requestedAction;
		protected List<WithdrawalReason.WithdrawalReasonBuilder> reason = new ArrayList<>();
		protected List<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> reportingRegime = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index) {
			if (partyTradeIdentifier==null) {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			return getIndex(partyTradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newPartyTradeIdentifier = PartyTradeIdentifier.builder();
						return newPartyTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		public List<? extends WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder> getPartyTradeInformation() {
			return partyTradeInformation;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder getOrCreatePartyTradeInformation(int index) {
			if (partyTradeInformation==null) {
				this.partyTradeInformation = new ArrayList<>();
			}
			return getIndex(partyTradeInformation, index, () -> {
						WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder newPartyTradeInformation = WithdrawalPartyTradeInformation.builder();
						return newPartyTradeInformation;
					});
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("requestedAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requestedAction")
		public RequestedWithdrawalAction.RequestedWithdrawalActionBuilder getRequestedAction() {
			return requestedAction;
		}
		
		@Override
		public RequestedWithdrawalAction.RequestedWithdrawalActionBuilder getOrCreateRequestedAction() {
			RequestedWithdrawalAction.RequestedWithdrawalActionBuilder result;
			if (requestedAction!=null) {
				result = requestedAction;
			}
			else {
				result = requestedAction = RequestedWithdrawalAction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends WithdrawalReason.WithdrawalReasonBuilder> getReason() {
			return reason;
		}
		
		@Override
		public WithdrawalReason.WithdrawalReasonBuilder getOrCreateReason(int index) {
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			return getIndex(reason, index, () -> {
						WithdrawalReason.WithdrawalReasonBuilder newReason = WithdrawalReason.builder();
						return newReason;
					});
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int index) {
			if (reportingRegime==null) {
				this.reportingRegime = new ArrayList<>();
			}
			return getIndex(reportingRegime, index, () -> {
						ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder newReportingRegime = ReportingRegimeIdentifier.builder();
						return newReportingRegime;
					});
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public Withdrawal.WithdrawalBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier) {
			if (_partyTradeIdentifier != null) {
				this.partyTradeIdentifier.add(_partyTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier, int idx) {
			getIndex(this.partyTradeIdentifier, idx, () -> _partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public Withdrawal.WithdrawalBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers == null) {
				this.partyTradeIdentifier = new ArrayList<>();
			} else {
				this.partyTradeIdentifier = partyTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		@Override
		public Withdrawal.WithdrawalBuilder addPartyTradeInformation(WithdrawalPartyTradeInformation _partyTradeInformation) {
			if (_partyTradeInformation != null) {
				this.partyTradeInformation.add(_partyTradeInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addPartyTradeInformation(WithdrawalPartyTradeInformation _partyTradeInformation, int idx) {
			getIndex(this.partyTradeInformation, idx, () -> _partyTradeInformation.toBuilder());
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addPartyTradeInformation(List<? extends WithdrawalPartyTradeInformation> partyTradeInformations) {
			if (partyTradeInformations != null) {
				for (final WithdrawalPartyTradeInformation toAdd : partyTradeInformations) {
					this.partyTradeInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeInformation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyTradeInformation")
		@Override
		public Withdrawal.WithdrawalBuilder setPartyTradeInformation(List<? extends WithdrawalPartyTradeInformation> partyTradeInformations) {
			if (partyTradeInformations == null) {
				this.partyTradeInformation = new ArrayList<>();
			} else {
				this.partyTradeInformation = partyTradeInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public Withdrawal.WithdrawalBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public Withdrawal.WithdrawalBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("requestedAction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("requestedAction")
		@Override
		public Withdrawal.WithdrawalBuilder setRequestedAction(RequestedWithdrawalAction _requestedAction) {
			this.requestedAction = _requestedAction == null ? null : _requestedAction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public Withdrawal.WithdrawalBuilder addReason(WithdrawalReason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addReason(WithdrawalReason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addReason(List<? extends WithdrawalReason> reasons) {
			if (reasons != null) {
				for (final WithdrawalReason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public Withdrawal.WithdrawalBuilder setReason(List<? extends WithdrawalReason> reasons) {
			if (reasons == null) {
				this.reason = new ArrayList<>();
			} else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingRegime")
		@Override
		public Withdrawal.WithdrawalBuilder addReportingRegime(ReportingRegimeIdentifier _reportingRegime) {
			if (_reportingRegime != null) {
				this.reportingRegime.add(_reportingRegime.toBuilder());
			}
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addReportingRegime(ReportingRegimeIdentifier _reportingRegime, int idx) {
			getIndex(this.reportingRegime, idx, () -> _reportingRegime.toBuilder());
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
			if (reportingRegimes != null) {
				for (final ReportingRegimeIdentifier toAdd : reportingRegimes) {
					this.reportingRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		@Override
		public Withdrawal.WithdrawalBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
			if (reportingRegimes == null) {
				this.reportingRegime = new ArrayList<>();
			} else {
				this.reportingRegime = reportingRegimes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Withdrawal build() {
			return new Withdrawal.WithdrawalImpl(this);
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Withdrawal.WithdrawalBuilder prune() {
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyTradeInformation = partyTradeInformation.stream().filter(b->b!=null).<WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (requestedAction!=null && !requestedAction.prune().hasData()) requestedAction = null;
			reason = reason.stream().filter(b->b!=null).<WithdrawalReason.WithdrawalReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			reportingRegime = reportingRegime.stream().filter(b->b!=null).<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeInformation()!=null && getPartyTradeInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getRequestedAction()!=null && getRequestedAction().hasData()) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRegime()!=null && getReportingRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Withdrawal.WithdrawalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Withdrawal.WithdrawalBuilder o = (Withdrawal.WithdrawalBuilder) other;
			
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			merger.mergeRosetta(getPartyTradeInformation(), o.getPartyTradeInformation(), this::getOrCreatePartyTradeInformation);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getRequestedAction(), o.getRequestedAction(), this::setRequestedAction);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			merger.mergeRosetta(getReportingRegime(), o.getReportingRegime(), this::getOrCreateReportingRegime);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Withdrawal _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(partyTradeInformation, _that.getPartyTradeInformation())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(requestedAction, _that.getRequestedAction())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (partyTradeInformation != null ? partyTradeInformation.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (requestedAction != null ? requestedAction.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithdrawalBuilder {" +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"partyTradeInformation=" + this.partyTradeInformation + ", " +
				"trade=" + this.trade + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"requestedAction=" + this.requestedAction + ", " +
				"reason=" + this.reason + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}
}
