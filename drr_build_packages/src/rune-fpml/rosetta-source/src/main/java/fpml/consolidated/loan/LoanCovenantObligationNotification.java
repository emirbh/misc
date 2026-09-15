package fpml.consolidated.loan;

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
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.LoanCovenantObligationNotificationMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
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
 * version "confirmation-5.13"
 *
 * Provision A loan notification used to convey servicing details related to a covenant obligation.
 *
 */
@RosettaDataType(value="LoanCovenantObligationNotification", builder=LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationNotification", model="fpml", builder=LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationNotification extends AbstractServicingNotification {

	LoanCovenantObligationNotificationMeta metaData = new LoanCovenantObligationNotificationMeta();

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
	List<? extends LoanCovenantObligationTask> getCovenantTask();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanCovenantObligationNotificationChoice0> getLoanCovenantObligationNotificationChoice0();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanCovenantObligationNotificationChoice1> getLoanCovenantObligationNotificationChoice1();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanCovenantObligationNotificationChoice2> getLoanCovenantObligationNotificationChoice2();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A legal entity or a subdivision of a legal entity.
	 *
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationNotification build();
	
	LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder toBuilder();
	
	static LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder builder() {
		return new LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationNotification> getType() {
		return LoanCovenantObligationNotification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
		processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
		processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.class, getEventPayment());
		processRosetta(path.newSubPath("covenantTask"), processor, LoanCovenantObligationTask.class, getCovenantTask());
		processRosetta(path.newSubPath("loanCovenantObligationNotificationChoice0"), processor, LoanCovenantObligationNotificationChoice0.class, getLoanCovenantObligationNotificationChoice0());
		processRosetta(path.newSubPath("loanCovenantObligationNotificationChoice1"), processor, LoanCovenantObligationNotificationChoice1.class, getLoanCovenantObligationNotificationChoice1());
		processRosetta(path.newSubPath("loanCovenantObligationNotificationChoice2"), processor, LoanCovenantObligationNotificationChoice2.class, getLoanCovenantObligationNotificationChoice2());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationNotificationBuilder extends LoanCovenantObligationNotification, AbstractServicingNotification.AbstractServicingNotificationBuilder {
		LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder getOrCreateCovenantTask(int index);
		@Override
		List<? extends LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder> getCovenantTask();
		LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder getOrCreateLoanCovenantObligationNotificationChoice0(int index);
		@Override
		List<? extends LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder> getLoanCovenantObligationNotificationChoice0();
		LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder getOrCreateLoanCovenantObligationNotificationChoice1(int index);
		@Override
		List<? extends LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder> getLoanCovenantObligationNotificationChoice1();
		LoanCovenantObligationNotificationChoice2.LoanCovenantObligationNotificationChoice2Builder getOrCreateLoanCovenantObligationNotificationChoice2(int index);
		@Override
		List<? extends LoanCovenantObligationNotificationChoice2.LoanCovenantObligationNotificationChoice2Builder> getLoanCovenantObligationNotificationChoice2();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addValidation(Validation validation);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addEventPayment(EventPayment eventPayment);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addEventPayment(EventPayment eventPayment, int idx);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCovenantTask(LoanCovenantObligationTask covenantTask);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCovenantTask(LoanCovenantObligationTask covenantTask, int idx);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCovenantTask(List<? extends LoanCovenantObligationTask> covenantTask);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setCovenantTask(List<? extends LoanCovenantObligationTask> covenantTask);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice0(LoanCovenantObligationNotificationChoice0 loanCovenantObligationNotificationChoice0);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice0(LoanCovenantObligationNotificationChoice0 loanCovenantObligationNotificationChoice0, int idx);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice0(List<? extends LoanCovenantObligationNotificationChoice0> loanCovenantObligationNotificationChoice0);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setLoanCovenantObligationNotificationChoice0(List<? extends LoanCovenantObligationNotificationChoice0> loanCovenantObligationNotificationChoice0);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice1(LoanCovenantObligationNotificationChoice1 loanCovenantObligationNotificationChoice1);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice1(LoanCovenantObligationNotificationChoice1 loanCovenantObligationNotificationChoice1, int idx);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice1(List<? extends LoanCovenantObligationNotificationChoice1> loanCovenantObligationNotificationChoice1);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setLoanCovenantObligationNotificationChoice1(List<? extends LoanCovenantObligationNotificationChoice1> loanCovenantObligationNotificationChoice1);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice2(LoanCovenantObligationNotificationChoice2 loanCovenantObligationNotificationChoice2);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice2(LoanCovenantObligationNotificationChoice2 loanCovenantObligationNotificationChoice2, int idx);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice2(List<? extends LoanCovenantObligationNotificationChoice2> loanCovenantObligationNotificationChoice2);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setLoanCovenantObligationNotificationChoice2(List<? extends LoanCovenantObligationNotificationChoice2> loanCovenantObligationNotificationChoice2);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addParty(Party party);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addParty(Party party, int idx);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addParty(List<? extends Party> party);
		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setParty(List<? extends Party> party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
			processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
			processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.EventPaymentBuilder.class, getEventPayment());
			processRosetta(path.newSubPath("covenantTask"), processor, LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder.class, getCovenantTask());
			processRosetta(path.newSubPath("loanCovenantObligationNotificationChoice0"), processor, LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder.class, getLoanCovenantObligationNotificationChoice0());
			processRosetta(path.newSubPath("loanCovenantObligationNotificationChoice1"), processor, LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder.class, getLoanCovenantObligationNotificationChoice1());
			processRosetta(path.newSubPath("loanCovenantObligationNotificationChoice2"), processor, LoanCovenantObligationNotificationChoice2.LoanCovenantObligationNotificationChoice2Builder.class, getLoanCovenantObligationNotificationChoice2());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationNotification  ***********************/
	class LoanCovenantObligationNotificationImpl extends AbstractServicingNotification.AbstractServicingNotificationImpl implements LoanCovenantObligationNotification {
		private final List<? extends LoanCovenantObligationTask> covenantTask;
		private final List<? extends LoanCovenantObligationNotificationChoice0> loanCovenantObligationNotificationChoice0;
		private final List<? extends LoanCovenantObligationNotificationChoice1> loanCovenantObligationNotificationChoice1;
		private final List<? extends LoanCovenantObligationNotificationChoice2> loanCovenantObligationNotificationChoice2;
		private final List<? extends Party> party;
		
		protected LoanCovenantObligationNotificationImpl(LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder builder) {
			super(builder);
			this.covenantTask = ofNullable(builder.getCovenantTask()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanCovenantObligationNotificationChoice0 = ofNullable(builder.getLoanCovenantObligationNotificationChoice0()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanCovenantObligationNotificationChoice1 = ofNullable(builder.getLoanCovenantObligationNotificationChoice1()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanCovenantObligationNotificationChoice2 = ofNullable(builder.getLoanCovenantObligationNotificationChoice2()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("covenantTask")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("covenantTask")
		public List<? extends LoanCovenantObligationTask> getCovenantTask() {
			return covenantTask;
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationNotificationChoice0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice0")
		public List<? extends LoanCovenantObligationNotificationChoice0> getLoanCovenantObligationNotificationChoice0() {
			return loanCovenantObligationNotificationChoice0;
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationNotificationChoice1")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice1")
		public List<? extends LoanCovenantObligationNotificationChoice1> getLoanCovenantObligationNotificationChoice1() {
			return loanCovenantObligationNotificationChoice1;
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationNotificationChoice2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice2")
		public List<? extends LoanCovenantObligationNotificationChoice2> getLoanCovenantObligationNotificationChoice2() {
			return loanCovenantObligationNotificationChoice2;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanCovenantObligationNotification build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder toBuilder() {
			LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCovenantTask()).ifPresent(builder::setCovenantTask);
			ofNullable(getLoanCovenantObligationNotificationChoice0()).ifPresent(builder::setLoanCovenantObligationNotificationChoice0);
			ofNullable(getLoanCovenantObligationNotificationChoice1()).ifPresent(builder::setLoanCovenantObligationNotificationChoice1);
			ofNullable(getLoanCovenantObligationNotificationChoice2()).ifPresent(builder::setLoanCovenantObligationNotificationChoice2);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanCovenantObligationNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(covenantTask, _that.getCovenantTask())) return false;
			if (!ListEquals.listEquals(loanCovenantObligationNotificationChoice0, _that.getLoanCovenantObligationNotificationChoice0())) return false;
			if (!ListEquals.listEquals(loanCovenantObligationNotificationChoice1, _that.getLoanCovenantObligationNotificationChoice1())) return false;
			if (!ListEquals.listEquals(loanCovenantObligationNotificationChoice2, _that.getLoanCovenantObligationNotificationChoice2())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (covenantTask != null ? covenantTask.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationNotificationChoice0 != null ? loanCovenantObligationNotificationChoice0.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationNotificationChoice1 != null ? loanCovenantObligationNotificationChoice1.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationNotificationChoice2 != null ? loanCovenantObligationNotificationChoice2.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationNotification {" +
				"covenantTask=" + this.covenantTask + ", " +
				"loanCovenantObligationNotificationChoice0=" + this.loanCovenantObligationNotificationChoice0 + ", " +
				"loanCovenantObligationNotificationChoice1=" + this.loanCovenantObligationNotificationChoice1 + ", " +
				"loanCovenantObligationNotificationChoice2=" + this.loanCovenantObligationNotificationChoice2 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationNotification  ***********************/
	class LoanCovenantObligationNotificationBuilderImpl extends AbstractServicingNotification.AbstractServicingNotificationBuilderImpl implements LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder {
	
		protected List<LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder> covenantTask = new ArrayList<>();
		protected List<LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder> loanCovenantObligationNotificationChoice0 = new ArrayList<>();
		protected List<LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder> loanCovenantObligationNotificationChoice1 = new ArrayList<>();
		protected List<LoanCovenantObligationNotificationChoice2.LoanCovenantObligationNotificationChoice2Builder> loanCovenantObligationNotificationChoice2 = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("covenantTask")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("covenantTask")
		public List<? extends LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder> getCovenantTask() {
			return covenantTask;
		}
		
		@Override
		public LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder getOrCreateCovenantTask(int index) {
			if (covenantTask==null) {
				this.covenantTask = new ArrayList<>();
			}
			return getIndex(covenantTask, index, () -> {
						LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder newCovenantTask = LoanCovenantObligationTask.builder();
						return newCovenantTask;
					});
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationNotificationChoice0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice0")
		public List<? extends LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder> getLoanCovenantObligationNotificationChoice0() {
			return loanCovenantObligationNotificationChoice0;
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder getOrCreateLoanCovenantObligationNotificationChoice0(int index) {
			if (loanCovenantObligationNotificationChoice0==null) {
				this.loanCovenantObligationNotificationChoice0 = new ArrayList<>();
			}
			return getIndex(loanCovenantObligationNotificationChoice0, index, () -> {
						LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder newLoanCovenantObligationNotificationChoice0 = LoanCovenantObligationNotificationChoice0.builder();
						return newLoanCovenantObligationNotificationChoice0;
					});
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationNotificationChoice1")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice1")
		public List<? extends LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder> getLoanCovenantObligationNotificationChoice1() {
			return loanCovenantObligationNotificationChoice1;
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder getOrCreateLoanCovenantObligationNotificationChoice1(int index) {
			if (loanCovenantObligationNotificationChoice1==null) {
				this.loanCovenantObligationNotificationChoice1 = new ArrayList<>();
			}
			return getIndex(loanCovenantObligationNotificationChoice1, index, () -> {
						LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder newLoanCovenantObligationNotificationChoice1 = LoanCovenantObligationNotificationChoice1.builder();
						return newLoanCovenantObligationNotificationChoice1;
					});
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationNotificationChoice2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice2")
		public List<? extends LoanCovenantObligationNotificationChoice2.LoanCovenantObligationNotificationChoice2Builder> getLoanCovenantObligationNotificationChoice2() {
			return loanCovenantObligationNotificationChoice2;
		}
		
		@Override
		public LoanCovenantObligationNotificationChoice2.LoanCovenantObligationNotificationChoice2Builder getOrCreateLoanCovenantObligationNotificationChoice2(int index) {
			if (loanCovenantObligationNotificationChoice2==null) {
				this.loanCovenantObligationNotificationChoice2 = new ArrayList<>();
			}
			return getIndex(loanCovenantObligationNotificationChoice2, index, () -> {
						LoanCovenantObligationNotificationChoice2.LoanCovenantObligationNotificationChoice2Builder newLoanCovenantObligationNotificationChoice2 = LoanCovenantObligationNotificationChoice2.builder();
						return newLoanCovenantObligationNotificationChoice2;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int index) {
			if (party==null) {
				this.party = new ArrayList<>();
			}
			return getIndex(party, index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addValidation(List<? extends Validation> validations) {
			if (validations != null) {
				for (final Validation toAdd : validations) {
					this.validation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCorrection")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds != null) {
				for (final CorrelationId toAdd : correlationIds) {
					this.correlationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds == null) {
				this.correlationId = new ArrayList<>();
			} else {
				this.correlationId = correlationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs != null) {
				for (final OnBehalfOf toAdd : onBehalfOfs) {
					this.onBehalfOf.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("noticeDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("noticeDate")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setIsGlobalOnly(Boolean _isGlobalOnly) {
			this.isGlobalOnly = _isGlobalOnly == null ? null : _isGlobalOnly;
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addEventPayment(EventPayment _eventPayment) {
			if (_eventPayment != null) {
				this.eventPayment.add(_eventPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addEventPayment(EventPayment _eventPayment, int idx) {
			getIndex(this.eventPayment, idx, () -> _eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (final EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments == null) {
				this.eventPayment = new ArrayList<>();
			} else {
				this.eventPayment = eventPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("covenantTask")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("covenantTask")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCovenantTask(LoanCovenantObligationTask _covenantTask) {
			if (_covenantTask != null) {
				this.covenantTask.add(_covenantTask.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCovenantTask(LoanCovenantObligationTask _covenantTask, int idx) {
			getIndex(this.covenantTask, idx, () -> _covenantTask.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addCovenantTask(List<? extends LoanCovenantObligationTask> covenantTasks) {
			if (covenantTasks != null) {
				for (final LoanCovenantObligationTask toAdd : covenantTasks) {
					this.covenantTask.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("covenantTask")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("covenantTask")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setCovenantTask(List<? extends LoanCovenantObligationTask> covenantTasks) {
			if (covenantTasks == null) {
				this.covenantTask = new ArrayList<>();
			} else {
				this.covenantTask = covenantTasks.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationNotificationChoice0")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice0")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice0(LoanCovenantObligationNotificationChoice0 _loanCovenantObligationNotificationChoice0) {
			if (_loanCovenantObligationNotificationChoice0 != null) {
				this.loanCovenantObligationNotificationChoice0.add(_loanCovenantObligationNotificationChoice0.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice0(LoanCovenantObligationNotificationChoice0 _loanCovenantObligationNotificationChoice0, int idx) {
			getIndex(this.loanCovenantObligationNotificationChoice0, idx, () -> _loanCovenantObligationNotificationChoice0.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice0(List<? extends LoanCovenantObligationNotificationChoice0> loanCovenantObligationNotificationChoice0s) {
			if (loanCovenantObligationNotificationChoice0s != null) {
				for (final LoanCovenantObligationNotificationChoice0 toAdd : loanCovenantObligationNotificationChoice0s) {
					this.loanCovenantObligationNotificationChoice0.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationNotificationChoice0")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice0")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setLoanCovenantObligationNotificationChoice0(List<? extends LoanCovenantObligationNotificationChoice0> loanCovenantObligationNotificationChoice0s) {
			if (loanCovenantObligationNotificationChoice0s == null) {
				this.loanCovenantObligationNotificationChoice0 = new ArrayList<>();
			} else {
				this.loanCovenantObligationNotificationChoice0 = loanCovenantObligationNotificationChoice0s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationNotificationChoice1")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice1")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice1(LoanCovenantObligationNotificationChoice1 _loanCovenantObligationNotificationChoice1) {
			if (_loanCovenantObligationNotificationChoice1 != null) {
				this.loanCovenantObligationNotificationChoice1.add(_loanCovenantObligationNotificationChoice1.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice1(LoanCovenantObligationNotificationChoice1 _loanCovenantObligationNotificationChoice1, int idx) {
			getIndex(this.loanCovenantObligationNotificationChoice1, idx, () -> _loanCovenantObligationNotificationChoice1.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice1(List<? extends LoanCovenantObligationNotificationChoice1> loanCovenantObligationNotificationChoice1s) {
			if (loanCovenantObligationNotificationChoice1s != null) {
				for (final LoanCovenantObligationNotificationChoice1 toAdd : loanCovenantObligationNotificationChoice1s) {
					this.loanCovenantObligationNotificationChoice1.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationNotificationChoice1")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice1")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setLoanCovenantObligationNotificationChoice1(List<? extends LoanCovenantObligationNotificationChoice1> loanCovenantObligationNotificationChoice1s) {
			if (loanCovenantObligationNotificationChoice1s == null) {
				this.loanCovenantObligationNotificationChoice1 = new ArrayList<>();
			} else {
				this.loanCovenantObligationNotificationChoice1 = loanCovenantObligationNotificationChoice1s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationNotificationChoice2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice2")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice2(LoanCovenantObligationNotificationChoice2 _loanCovenantObligationNotificationChoice2) {
			if (_loanCovenantObligationNotificationChoice2 != null) {
				this.loanCovenantObligationNotificationChoice2.add(_loanCovenantObligationNotificationChoice2.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice2(LoanCovenantObligationNotificationChoice2 _loanCovenantObligationNotificationChoice2, int idx) {
			getIndex(this.loanCovenantObligationNotificationChoice2, idx, () -> _loanCovenantObligationNotificationChoice2.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addLoanCovenantObligationNotificationChoice2(List<? extends LoanCovenantObligationNotificationChoice2> loanCovenantObligationNotificationChoice2s) {
			if (loanCovenantObligationNotificationChoice2s != null) {
				for (final LoanCovenantObligationNotificationChoice2 toAdd : loanCovenantObligationNotificationChoice2s) {
					this.loanCovenantObligationNotificationChoice2.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationNotificationChoice2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanCovenantObligationNotificationChoice2")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setLoanCovenantObligationNotificationChoice2(List<? extends LoanCovenantObligationNotificationChoice2> loanCovenantObligationNotificationChoice2s) {
			if (loanCovenantObligationNotificationChoice2s == null) {
				this.loanCovenantObligationNotificationChoice2 = new ArrayList<>();
			} else {
				this.loanCovenantObligationNotificationChoice2 = loanCovenantObligationNotificationChoice2s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationNotification build() {
			return new LoanCovenantObligationNotification.LoanCovenantObligationNotificationImpl(this);
		}
		
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder prune() {
			super.prune();
			covenantTask = covenantTask.stream().filter(b->b!=null).<LoanCovenantObligationTask.LoanCovenantObligationTaskBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanCovenantObligationNotificationChoice0 = loanCovenantObligationNotificationChoice0.stream().filter(b->b!=null).<LoanCovenantObligationNotificationChoice0.LoanCovenantObligationNotificationChoice0Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanCovenantObligationNotificationChoice1 = loanCovenantObligationNotificationChoice1.stream().filter(b->b!=null).<LoanCovenantObligationNotificationChoice1.LoanCovenantObligationNotificationChoice1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanCovenantObligationNotificationChoice2 = loanCovenantObligationNotificationChoice2.stream().filter(b->b!=null).<LoanCovenantObligationNotificationChoice2.LoanCovenantObligationNotificationChoice2Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCovenantTask()!=null && getCovenantTask().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanCovenantObligationNotificationChoice0()!=null && getLoanCovenantObligationNotificationChoice0().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanCovenantObligationNotificationChoice1()!=null && getLoanCovenantObligationNotificationChoice1().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanCovenantObligationNotificationChoice2()!=null && getLoanCovenantObligationNotificationChoice2().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder o = (LoanCovenantObligationNotification.LoanCovenantObligationNotificationBuilder) other;
			
			merger.mergeRosetta(getCovenantTask(), o.getCovenantTask(), this::getOrCreateCovenantTask);
			merger.mergeRosetta(getLoanCovenantObligationNotificationChoice0(), o.getLoanCovenantObligationNotificationChoice0(), this::getOrCreateLoanCovenantObligationNotificationChoice0);
			merger.mergeRosetta(getLoanCovenantObligationNotificationChoice1(), o.getLoanCovenantObligationNotificationChoice1(), this::getOrCreateLoanCovenantObligationNotificationChoice1);
			merger.mergeRosetta(getLoanCovenantObligationNotificationChoice2(), o.getLoanCovenantObligationNotificationChoice2(), this::getOrCreateLoanCovenantObligationNotificationChoice2);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanCovenantObligationNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(covenantTask, _that.getCovenantTask())) return false;
			if (!ListEquals.listEquals(loanCovenantObligationNotificationChoice0, _that.getLoanCovenantObligationNotificationChoice0())) return false;
			if (!ListEquals.listEquals(loanCovenantObligationNotificationChoice1, _that.getLoanCovenantObligationNotificationChoice1())) return false;
			if (!ListEquals.listEquals(loanCovenantObligationNotificationChoice2, _that.getLoanCovenantObligationNotificationChoice2())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (covenantTask != null ? covenantTask.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationNotificationChoice0 != null ? loanCovenantObligationNotificationChoice0.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationNotificationChoice1 != null ? loanCovenantObligationNotificationChoice1.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationNotificationChoice2 != null ? loanCovenantObligationNotificationChoice2.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationNotificationBuilder {" +
				"covenantTask=" + this.covenantTask + ", " +
				"loanCovenantObligationNotificationChoice0=" + this.loanCovenantObligationNotificationChoice0 + ", " +
				"loanCovenantObligationNotificationChoice1=" + this.loanCovenantObligationNotificationChoice1 + ", " +
				"loanCovenantObligationNotificationChoice2=" + this.loanCovenantObligationNotificationChoice2 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
