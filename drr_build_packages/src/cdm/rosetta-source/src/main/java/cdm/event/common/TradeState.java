package cdm.event.common;

import cdm.event.common.meta.TradeStateMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
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
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the fundamental financial information that can be changed by a Primitive Event and by extension any business or life-cycle event. Each TradeState specifies where a Trade is in its life-cycle. TradeState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
 * @version 6.23.0
 */
@RosettaDataType(value="TradeState", builder=TradeState.TradeStateBuilderImpl.class, version="6.23.0")
@RuneDataType(value="TradeState", model="cdm", builder=TradeState.TradeStateBuilderImpl.class, version="6.23.0")
public interface TradeState extends RosettaModelObject, GlobalKey {

	TradeStateMeta metaData = new TradeStateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Represents the Trade that has been effected by a business or life-cycle event.
	 */
	Trade getTrade();
	/**
	 * Represents the State of the Trade through its life-cycle.
	 */
	State getState();
	/**
	 * Represents the updated Trade attributes which can change as the result of a reset event. Only the changed values are captured, leaving the remaining data attributes empty. See Create_Reset function for further details on how TradeState is used in the Reset event. The TradeState data type is used to maintain backwards compatibility with the current Reset mechanism.
	 */
	List<? extends Reset> getResetHistory();
	/**
	 * Represents the updated Trade attributes which can change as the result of a transfer event.
	 */
	List<? extends TransferState> getTransferHistory();
	/**
	 * Represents the observed events related to a particular product or process, such as credit events or corporate actions.
	 */
	List<? extends ObservationEvent> getObservationHistory();
	List<? extends Valuation> getValuationHistory();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	TradeState build();
	
	TradeState.TradeStateBuilder toBuilder();
	
	static TradeState.TradeStateBuilder builder() {
		return new TradeState.TradeStateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeState> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeState> getType() {
		return TradeState.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("state"), processor, State.class, getState());
		processRosetta(path.newSubPath("resetHistory"), processor, Reset.class, getResetHistory());
		processRosetta(path.newSubPath("transferHistory"), processor, TransferState.class, getTransferHistory());
		processRosetta(path.newSubPath("observationHistory"), processor, ObservationEvent.class, getObservationHistory());
		processRosetta(path.newSubPath("valuationHistory"), processor, Valuation.class, getValuationHistory());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeStateBuilder extends TradeState, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		State.StateBuilder getOrCreateState();
		@Override
		State.StateBuilder getState();
		Reset.ResetBuilder getOrCreateResetHistory(int index);
		@Override
		List<? extends Reset.ResetBuilder> getResetHistory();
		TransferState.TransferStateBuilder getOrCreateTransferHistory(int index);
		@Override
		List<? extends TransferState.TransferStateBuilder> getTransferHistory();
		ObservationEvent.ObservationEventBuilder getOrCreateObservationHistory(int index);
		@Override
		List<? extends ObservationEvent.ObservationEventBuilder> getObservationHistory();
		Valuation.ValuationBuilder getOrCreateValuationHistory(int index);
		@Override
		List<? extends Valuation.ValuationBuilder> getValuationHistory();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		TradeState.TradeStateBuilder setTrade(Trade trade);
		TradeState.TradeStateBuilder setState(State state);
		TradeState.TradeStateBuilder addResetHistory(Reset resetHistory);
		TradeState.TradeStateBuilder addResetHistory(Reset resetHistory, int idx);
		TradeState.TradeStateBuilder addResetHistory(List<? extends Reset> resetHistory);
		TradeState.TradeStateBuilder setResetHistory(List<? extends Reset> resetHistory);
		TradeState.TradeStateBuilder addTransferHistory(TransferState transferHistory);
		TradeState.TradeStateBuilder addTransferHistory(TransferState transferHistory, int idx);
		TradeState.TradeStateBuilder addTransferHistory(List<? extends TransferState> transferHistory);
		TradeState.TradeStateBuilder setTransferHistory(List<? extends TransferState> transferHistory);
		TradeState.TradeStateBuilder addObservationHistory(ObservationEvent observationHistory);
		TradeState.TradeStateBuilder addObservationHistory(ObservationEvent observationHistory, int idx);
		TradeState.TradeStateBuilder addObservationHistory(List<? extends ObservationEvent> observationHistory);
		TradeState.TradeStateBuilder setObservationHistory(List<? extends ObservationEvent> observationHistory);
		TradeState.TradeStateBuilder addValuationHistory(Valuation valuationHistory);
		TradeState.TradeStateBuilder addValuationHistory(Valuation valuationHistory, int idx);
		TradeState.TradeStateBuilder addValuationHistory(List<? extends Valuation> valuationHistory);
		TradeState.TradeStateBuilder setValuationHistory(List<? extends Valuation> valuationHistory);
		TradeState.TradeStateBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("state"), processor, State.StateBuilder.class, getState());
			processRosetta(path.newSubPath("resetHistory"), processor, Reset.ResetBuilder.class, getResetHistory());
			processRosetta(path.newSubPath("transferHistory"), processor, TransferState.TransferStateBuilder.class, getTransferHistory());
			processRosetta(path.newSubPath("observationHistory"), processor, ObservationEvent.ObservationEventBuilder.class, getObservationHistory());
			processRosetta(path.newSubPath("valuationHistory"), processor, Valuation.ValuationBuilder.class, getValuationHistory());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		TradeState.TradeStateBuilder prune();
	}

	/*********************** Immutable Implementation of TradeState  ***********************/
	class TradeStateImpl implements TradeState {
		private final Trade trade;
		private final State state;
		private final List<? extends Reset> resetHistory;
		private final List<? extends TransferState> transferHistory;
		private final List<? extends ObservationEvent> observationHistory;
		private final List<? extends Valuation> valuationHistory;
		private final MetaFields meta;
		
		protected TradeStateImpl(TradeState.TradeStateBuilder builder) {
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.state = ofNullable(builder.getState()).map(f->f.build()).orElse(null);
			this.resetHistory = ofNullable(builder.getResetHistory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transferHistory = ofNullable(builder.getTransferHistory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.observationHistory = ofNullable(builder.getObservationHistory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.valuationHistory = ofNullable(builder.getValuationHistory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("state")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("state")
		public State getState() {
			return state;
		}
		
		@Override
		@RosettaAttribute("resetHistory")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("resetHistory")
		public List<? extends Reset> getResetHistory() {
			return resetHistory;
		}
		
		@Override
		@RosettaAttribute("transferHistory")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("transferHistory")
		public List<? extends TransferState> getTransferHistory() {
			return transferHistory;
		}
		
		@Override
		@RosettaAttribute("observationHistory")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("observationHistory")
		public List<? extends ObservationEvent> getObservationHistory() {
			return observationHistory;
		}
		
		@Override
		@RosettaAttribute("valuationHistory")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("valuationHistory")
		public List<? extends Valuation> getValuationHistory() {
			return valuationHistory;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public TradeState build() {
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder toBuilder() {
			TradeState.TradeStateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeState.TradeStateBuilder builder) {
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getState()).ifPresent(builder::setState);
			ofNullable(getResetHistory()).ifPresent(builder::setResetHistory);
			ofNullable(getTransferHistory()).ifPresent(builder::setTransferHistory);
			ofNullable(getObservationHistory()).ifPresent(builder::setObservationHistory);
			ofNullable(getValuationHistory()).ifPresent(builder::setValuationHistory);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeState _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!ListEquals.listEquals(resetHistory, _that.getResetHistory())) return false;
			if (!ListEquals.listEquals(transferHistory, _that.getTransferHistory())) return false;
			if (!ListEquals.listEquals(observationHistory, _that.getObservationHistory())) return false;
			if (!ListEquals.listEquals(valuationHistory, _that.getValuationHistory())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (resetHistory != null ? resetHistory.hashCode() : 0);
			_result = 31 * _result + (transferHistory != null ? transferHistory.hashCode() : 0);
			_result = 31 * _result + (observationHistory != null ? observationHistory.hashCode() : 0);
			_result = 31 * _result + (valuationHistory != null ? valuationHistory.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeState {" +
				"trade=" + this.trade + ", " +
				"state=" + this.state + ", " +
				"resetHistory=" + this.resetHistory + ", " +
				"transferHistory=" + this.transferHistory + ", " +
				"observationHistory=" + this.observationHistory + ", " +
				"valuationHistory=" + this.valuationHistory + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeState  ***********************/
	class TradeStateBuilderImpl implements TradeState.TradeStateBuilder {
	
		protected Trade.TradeBuilder trade;
		protected State.StateBuilder state;
		protected List<Reset.ResetBuilder> resetHistory = new ArrayList<>();
		protected List<TransferState.TransferStateBuilder> transferHistory = new ArrayList<>();
		protected List<ObservationEvent.ObservationEventBuilder> observationHistory = new ArrayList<>();
		protected List<Valuation.ValuationBuilder> valuationHistory = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("state")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("state")
		public State.StateBuilder getState() {
			return state;
		}
		
		@Override
		public State.StateBuilder getOrCreateState() {
			State.StateBuilder result;
			if (state!=null) {
				result = state;
			}
			else {
				result = state = State.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetHistory")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("resetHistory")
		public List<? extends Reset.ResetBuilder> getResetHistory() {
			return resetHistory;
		}
		
		@Override
		public Reset.ResetBuilder getOrCreateResetHistory(int index) {
			if (resetHistory==null) {
				this.resetHistory = new ArrayList<>();
			}
			return getIndex(resetHistory, index, () -> {
						Reset.ResetBuilder newResetHistory = Reset.builder();
						return newResetHistory;
					});
		}
		
		@Override
		@RosettaAttribute("transferHistory")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("transferHistory")
		public List<? extends TransferState.TransferStateBuilder> getTransferHistory() {
			return transferHistory;
		}
		
		@Override
		public TransferState.TransferStateBuilder getOrCreateTransferHistory(int index) {
			if (transferHistory==null) {
				this.transferHistory = new ArrayList<>();
			}
			return getIndex(transferHistory, index, () -> {
						TransferState.TransferStateBuilder newTransferHistory = TransferState.builder();
						return newTransferHistory;
					});
		}
		
		@Override
		@RosettaAttribute("observationHistory")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("observationHistory")
		public List<? extends ObservationEvent.ObservationEventBuilder> getObservationHistory() {
			return observationHistory;
		}
		
		@Override
		public ObservationEvent.ObservationEventBuilder getOrCreateObservationHistory(int index) {
			if (observationHistory==null) {
				this.observationHistory = new ArrayList<>();
			}
			return getIndex(observationHistory, index, () -> {
						ObservationEvent.ObservationEventBuilder newObservationHistory = ObservationEvent.builder();
						return newObservationHistory;
					});
		}
		
		@Override
		@RosettaAttribute("valuationHistory")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("valuationHistory")
		public List<? extends Valuation.ValuationBuilder> getValuationHistory() {
			return valuationHistory;
		}
		
		@Override
		public Valuation.ValuationBuilder getOrCreateValuationHistory(int index) {
			if (valuationHistory==null) {
				this.valuationHistory = new ArrayList<>();
			}
			return getIndex(valuationHistory, index, () -> {
						Valuation.ValuationBuilder newValuationHistory = Valuation.builder();
						return newValuationHistory;
					});
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("trade")
		@Override
		public TradeState.TradeStateBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("state")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("state")
		@Override
		public TradeState.TradeStateBuilder setState(State _state) {
			this.state = _state == null ? null : _state.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resetHistory")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("resetHistory")
		@Override
		public TradeState.TradeStateBuilder addResetHistory(Reset _resetHistory) {
			if (_resetHistory != null) {
				this.resetHistory.add(_resetHistory.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder addResetHistory(Reset _resetHistory, int idx) {
			getIndex(this.resetHistory, idx, () -> _resetHistory.toBuilder());
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder addResetHistory(List<? extends Reset> resetHistorys) {
			if (resetHistorys != null) {
				for (final Reset toAdd : resetHistorys) {
					this.resetHistory.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("resetHistory")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("resetHistory")
		@Override
		public TradeState.TradeStateBuilder setResetHistory(List<? extends Reset> resetHistorys) {
			if (resetHistorys == null) {
				this.resetHistory = new ArrayList<>();
			} else {
				this.resetHistory = resetHistorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("transferHistory")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("transferHistory")
		@Override
		public TradeState.TradeStateBuilder addTransferHistory(TransferState _transferHistory) {
			if (_transferHistory != null) {
				this.transferHistory.add(_transferHistory.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder addTransferHistory(TransferState _transferHistory, int idx) {
			getIndex(this.transferHistory, idx, () -> _transferHistory.toBuilder());
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder addTransferHistory(List<? extends TransferState> transferHistorys) {
			if (transferHistorys != null) {
				for (final TransferState toAdd : transferHistorys) {
					this.transferHistory.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("transferHistory")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("transferHistory")
		@Override
		public TradeState.TradeStateBuilder setTransferHistory(List<? extends TransferState> transferHistorys) {
			if (transferHistorys == null) {
				this.transferHistory = new ArrayList<>();
			} else {
				this.transferHistory = transferHistorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("observationHistory")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("observationHistory")
		@Override
		public TradeState.TradeStateBuilder addObservationHistory(ObservationEvent _observationHistory) {
			if (_observationHistory != null) {
				this.observationHistory.add(_observationHistory.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder addObservationHistory(ObservationEvent _observationHistory, int idx) {
			getIndex(this.observationHistory, idx, () -> _observationHistory.toBuilder());
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder addObservationHistory(List<? extends ObservationEvent> observationHistorys) {
			if (observationHistorys != null) {
				for (final ObservationEvent toAdd : observationHistorys) {
					this.observationHistory.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("observationHistory")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("observationHistory")
		@Override
		public TradeState.TradeStateBuilder setObservationHistory(List<? extends ObservationEvent> observationHistorys) {
			if (observationHistorys == null) {
				this.observationHistory = new ArrayList<>();
			} else {
				this.observationHistory = observationHistorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("valuationHistory")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("valuationHistory")
		@Override
		public TradeState.TradeStateBuilder addValuationHistory(Valuation _valuationHistory) {
			if (_valuationHistory != null) {
				this.valuationHistory.add(_valuationHistory.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder addValuationHistory(Valuation _valuationHistory, int idx) {
			getIndex(this.valuationHistory, idx, () -> _valuationHistory.toBuilder());
			return this;
		}
		
		@Override
		public TradeState.TradeStateBuilder addValuationHistory(List<? extends Valuation> valuationHistorys) {
			if (valuationHistorys != null) {
				for (final Valuation toAdd : valuationHistorys) {
					this.valuationHistory.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("valuationHistory")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("valuationHistory")
		@Override
		public TradeState.TradeStateBuilder setValuationHistory(List<? extends Valuation> valuationHistorys) {
			if (valuationHistorys == null) {
				this.valuationHistory = new ArrayList<>();
			} else {
				this.valuationHistory = valuationHistorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public TradeState.TradeStateBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public TradeState build() {
			return new TradeState.TradeStateImpl(this);
		}
		
		@Override
		public TradeState.TradeStateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeState.TradeStateBuilder prune() {
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (state!=null && !state.prune().hasData()) state = null;
			resetHistory = resetHistory.stream().filter(b->b!=null).<Reset.ResetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			transferHistory = transferHistory.stream().filter(b->b!=null).<TransferState.TransferStateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			observationHistory = observationHistory.stream().filter(b->b!=null).<ObservationEvent.ObservationEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			valuationHistory = valuationHistory.stream().filter(b->b!=null).<Valuation.ValuationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getState()!=null && getState().hasData()) return true;
			if (getResetHistory()!=null && getResetHistory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransferHistory()!=null && getTransferHistory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getObservationHistory()!=null && getObservationHistory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getValuationHistory()!=null && getValuationHistory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeState.TradeStateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeState.TradeStateBuilder o = (TradeState.TradeStateBuilder) other;
			
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getState(), o.getState(), this::setState);
			merger.mergeRosetta(getResetHistory(), o.getResetHistory(), this::getOrCreateResetHistory);
			merger.mergeRosetta(getTransferHistory(), o.getTransferHistory(), this::getOrCreateTransferHistory);
			merger.mergeRosetta(getObservationHistory(), o.getObservationHistory(), this::getOrCreateObservationHistory);
			merger.mergeRosetta(getValuationHistory(), o.getValuationHistory(), this::getOrCreateValuationHistory);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeState _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(state, _that.getState())) return false;
			if (!ListEquals.listEquals(resetHistory, _that.getResetHistory())) return false;
			if (!ListEquals.listEquals(transferHistory, _that.getTransferHistory())) return false;
			if (!ListEquals.listEquals(observationHistory, _that.getObservationHistory())) return false;
			if (!ListEquals.listEquals(valuationHistory, _that.getValuationHistory())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (state != null ? state.hashCode() : 0);
			_result = 31 * _result + (resetHistory != null ? resetHistory.hashCode() : 0);
			_result = 31 * _result + (transferHistory != null ? transferHistory.hashCode() : 0);
			_result = 31 * _result + (observationHistory != null ? observationHistory.hashCode() : 0);
			_result = 31 * _result + (valuationHistory != null ? valuationHistory.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeStateBuilder {" +
				"trade=" + this.trade + ", " +
				"state=" + this.state + ", " +
				"resetHistory=" + this.resetHistory + ", " +
				"transferHistory=" + this.transferHistory + ", " +
				"observationHistory=" + this.observationHistory + ", " +
				"valuationHistory=" + this.valuationHistory + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
