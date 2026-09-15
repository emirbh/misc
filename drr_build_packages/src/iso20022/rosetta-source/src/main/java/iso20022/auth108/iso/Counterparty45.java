package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.Counterparty45Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to counterparty identification.
 * @version ${project.version}
 */
@RosettaDataType(value="Counterparty45", builder=Counterparty45.Counterparty45BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Counterparty45", model="iso20022", builder=Counterparty45.Counterparty45BuilderImpl.class, version="${project.version}")
public interface Counterparty45 extends RosettaModelObject {

	Counterparty45Meta metaData = new Counterparty45Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique code identifying the reporting counterparty of the contract.
	 */
	PartyIdentification248Choice getId();
	/**
	 * Indicates if the reporting counterparty is a central counterparty, a financial, non-financial counterparty or other type of counterparty in accordance with regulation.
	 */
	CounterpartyTradeNature15Choice getNtr();
	/**
	 * Identifies the trading capacity of the seller.
	 */
	TradingCapacity7Code getTradgCpcty();
	/**
	 * Indicates the direction or side of the derivative transaction from the perspective of the reporting counterparty.     Usage:  CounterpartySide should be used for the instruments such as most forwards and forward-like contracts (except for foreign exchange forwards and foreign exchange non-deliverable forwards); most options and option-like contracts including swaptions, caps and floors; credit default swaps; variance, volatility and correlation swaps; contracts for difference and spreadbets.
	 */
	Direction4Choice getDrctnOrSd();
	/**
	 * Location of the trading desk or trader responsible for the decision of entering into or execution of the transaction.
	 */
	String getTradrLctn();
	/**
	 * Location of the trade party or the branch/office of the trade party to which the transaction is booked.
	 */
	String getBookgLctn();
	/**
	 * Provides details on the reporting exemption of a counterparty.
	 */
	ReportingExemption1 getRptgXmptn();

	/*********************** Build Methods  ***********************/
	Counterparty45 build();
	
	Counterparty45.Counterparty45Builder toBuilder();
	
	static Counterparty45.Counterparty45Builder builder() {
		return new Counterparty45.Counterparty45BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Counterparty45> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Counterparty45> getType() {
		return Counterparty45.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, PartyIdentification248Choice.class, getId());
		processRosetta(path.newSubPath("ntr"), processor, CounterpartyTradeNature15Choice.class, getNtr());
		processor.processBasic(path.newSubPath("tradgCpcty"), TradingCapacity7Code.class, getTradgCpcty(), this);
		processRosetta(path.newSubPath("drctnOrSd"), processor, Direction4Choice.class, getDrctnOrSd());
		processor.processBasic(path.newSubPath("tradrLctn"), String.class, getTradrLctn(), this);
		processor.processBasic(path.newSubPath("bookgLctn"), String.class, getBookgLctn(), this);
		processRosetta(path.newSubPath("rptgXmptn"), processor, ReportingExemption1.class, getRptgXmptn());
	}
	

	/*********************** Builder Interface  ***********************/
	interface Counterparty45Builder extends Counterparty45, RosettaModelObjectBuilder {
		PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getOrCreateId();
		@Override
		PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getId();
		CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder getOrCreateNtr();
		@Override
		CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder getNtr();
		Direction4Choice.Direction4ChoiceBuilder getOrCreateDrctnOrSd();
		@Override
		Direction4Choice.Direction4ChoiceBuilder getDrctnOrSd();
		ReportingExemption1.ReportingExemption1Builder getOrCreateRptgXmptn();
		@Override
		ReportingExemption1.ReportingExemption1Builder getRptgXmptn();
		Counterparty45.Counterparty45Builder setId(PartyIdentification248Choice id);
		Counterparty45.Counterparty45Builder setNtr(CounterpartyTradeNature15Choice ntr);
		Counterparty45.Counterparty45Builder setTradgCpcty(TradingCapacity7Code tradgCpcty);
		Counterparty45.Counterparty45Builder setDrctnOrSd(Direction4Choice drctnOrSd);
		Counterparty45.Counterparty45Builder setTradrLctn(String tradrLctn);
		Counterparty45.Counterparty45Builder setBookgLctn(String bookgLctn);
		Counterparty45.Counterparty45Builder setRptgXmptn(ReportingExemption1 rptgXmptn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, PartyIdentification248Choice.PartyIdentification248ChoiceBuilder.class, getId());
			processRosetta(path.newSubPath("ntr"), processor, CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder.class, getNtr());
			processor.processBasic(path.newSubPath("tradgCpcty"), TradingCapacity7Code.class, getTradgCpcty(), this);
			processRosetta(path.newSubPath("drctnOrSd"), processor, Direction4Choice.Direction4ChoiceBuilder.class, getDrctnOrSd());
			processor.processBasic(path.newSubPath("tradrLctn"), String.class, getTradrLctn(), this);
			processor.processBasic(path.newSubPath("bookgLctn"), String.class, getBookgLctn(), this);
			processRosetta(path.newSubPath("rptgXmptn"), processor, ReportingExemption1.ReportingExemption1Builder.class, getRptgXmptn());
		}
		

		Counterparty45.Counterparty45Builder prune();
	}

	/*********************** Immutable Implementation of Counterparty45  ***********************/
	class Counterparty45Impl implements Counterparty45 {
		private final PartyIdentification248Choice id;
		private final CounterpartyTradeNature15Choice ntr;
		private final TradingCapacity7Code tradgCpcty;
		private final Direction4Choice drctnOrSd;
		private final String tradrLctn;
		private final String bookgLctn;
		private final ReportingExemption1 rptgXmptn;
		
		protected Counterparty45Impl(Counterparty45.Counterparty45Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.ntr = ofNullable(builder.getNtr()).map(f->f.build()).orElse(null);
			this.tradgCpcty = builder.getTradgCpcty();
			this.drctnOrSd = ofNullable(builder.getDrctnOrSd()).map(f->f.build()).orElse(null);
			this.tradrLctn = builder.getTradrLctn();
			this.bookgLctn = builder.getBookgLctn();
			this.rptgXmptn = ofNullable(builder.getRptgXmptn()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public PartyIdentification248Choice getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntr")
		public CounterpartyTradeNature15Choice getNtr() {
			return ntr;
		}
		
		@Override
		@RosettaAttribute("tradgCpcty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradgCpcty")
		public TradingCapacity7Code getTradgCpcty() {
			return tradgCpcty;
		}
		
		@Override
		@RosettaAttribute("drctnOrSd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drctnOrSd")
		public Direction4Choice getDrctnOrSd() {
			return drctnOrSd;
		}
		
		@Override
		@RosettaAttribute("tradrLctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradrLctn")
		public String getTradrLctn() {
			return tradrLctn;
		}
		
		@Override
		@RosettaAttribute("bookgLctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bookgLctn")
		public String getBookgLctn() {
			return bookgLctn;
		}
		
		@Override
		@RosettaAttribute("rptgXmptn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptgXmptn")
		public ReportingExemption1 getRptgXmptn() {
			return rptgXmptn;
		}
		
		@Override
		public Counterparty45 build() {
			return this;
		}
		
		@Override
		public Counterparty45.Counterparty45Builder toBuilder() {
			Counterparty45.Counterparty45Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Counterparty45.Counterparty45Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getNtr()).ifPresent(builder::setNtr);
			ofNullable(getTradgCpcty()).ifPresent(builder::setTradgCpcty);
			ofNullable(getDrctnOrSd()).ifPresent(builder::setDrctnOrSd);
			ofNullable(getTradrLctn()).ifPresent(builder::setTradrLctn);
			ofNullable(getBookgLctn()).ifPresent(builder::setBookgLctn);
			ofNullable(getRptgXmptn()).ifPresent(builder::setRptgXmptn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty45 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(ntr, _that.getNtr())) return false;
			if (!Objects.equals(tradgCpcty, _that.getTradgCpcty())) return false;
			if (!Objects.equals(drctnOrSd, _that.getDrctnOrSd())) return false;
			if (!Objects.equals(tradrLctn, _that.getTradrLctn())) return false;
			if (!Objects.equals(bookgLctn, _that.getBookgLctn())) return false;
			if (!Objects.equals(rptgXmptn, _that.getRptgXmptn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (ntr != null ? ntr.hashCode() : 0);
			_result = 31 * _result + (tradgCpcty != null ? tradgCpcty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (drctnOrSd != null ? drctnOrSd.hashCode() : 0);
			_result = 31 * _result + (tradrLctn != null ? tradrLctn.hashCode() : 0);
			_result = 31 * _result + (bookgLctn != null ? bookgLctn.hashCode() : 0);
			_result = 31 * _result + (rptgXmptn != null ? rptgXmptn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty45 {" +
				"id=" + this.id + ", " +
				"ntr=" + this.ntr + ", " +
				"tradgCpcty=" + this.tradgCpcty + ", " +
				"drctnOrSd=" + this.drctnOrSd + ", " +
				"tradrLctn=" + this.tradrLctn + ", " +
				"bookgLctn=" + this.bookgLctn + ", " +
				"rptgXmptn=" + this.rptgXmptn +
			'}';
		}
	}

	/*********************** Builder Implementation of Counterparty45  ***********************/
	class Counterparty45BuilderImpl implements Counterparty45.Counterparty45Builder {
	
		protected PartyIdentification248Choice.PartyIdentification248ChoiceBuilder id;
		protected CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder ntr;
		protected TradingCapacity7Code tradgCpcty;
		protected Direction4Choice.Direction4ChoiceBuilder drctnOrSd;
		protected String tradrLctn;
		protected String bookgLctn;
		protected ReportingExemption1.ReportingExemption1Builder rptgXmptn;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getId() {
			return id;
		}
		
		@Override
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getOrCreateId() {
			PartyIdentification248Choice.PartyIdentification248ChoiceBuilder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = PartyIdentification248Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntr")
		public CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder getNtr() {
			return ntr;
		}
		
		@Override
		public CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder getOrCreateNtr() {
			CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder result;
			if (ntr!=null) {
				result = ntr;
			}
			else {
				result = ntr = CounterpartyTradeNature15Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradgCpcty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradgCpcty")
		public TradingCapacity7Code getTradgCpcty() {
			return tradgCpcty;
		}
		
		@Override
		@RosettaAttribute("drctnOrSd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drctnOrSd")
		public Direction4Choice.Direction4ChoiceBuilder getDrctnOrSd() {
			return drctnOrSd;
		}
		
		@Override
		public Direction4Choice.Direction4ChoiceBuilder getOrCreateDrctnOrSd() {
			Direction4Choice.Direction4ChoiceBuilder result;
			if (drctnOrSd!=null) {
				result = drctnOrSd;
			}
			else {
				result = drctnOrSd = Direction4Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradrLctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradrLctn")
		public String getTradrLctn() {
			return tradrLctn;
		}
		
		@Override
		@RosettaAttribute("bookgLctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bookgLctn")
		public String getBookgLctn() {
			return bookgLctn;
		}
		
		@Override
		@RosettaAttribute("rptgXmptn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptgXmptn")
		public ReportingExemption1.ReportingExemption1Builder getRptgXmptn() {
			return rptgXmptn;
		}
		
		@Override
		public ReportingExemption1.ReportingExemption1Builder getOrCreateRptgXmptn() {
			ReportingExemption1.ReportingExemption1Builder result;
			if (rptgXmptn!=null) {
				result = rptgXmptn;
			}
			else {
				result = rptgXmptn = ReportingExemption1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public Counterparty45.Counterparty45Builder setId(PartyIdentification248Choice _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntr")
		@Override
		public Counterparty45.Counterparty45Builder setNtr(CounterpartyTradeNature15Choice _ntr) {
			this.ntr = _ntr == null ? null : _ntr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradgCpcty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradgCpcty")
		@Override
		public Counterparty45.Counterparty45Builder setTradgCpcty(TradingCapacity7Code _tradgCpcty) {
			this.tradgCpcty = _tradgCpcty == null ? null : _tradgCpcty;
			return this;
		}
		
		@RosettaAttribute("drctnOrSd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("drctnOrSd")
		@Override
		public Counterparty45.Counterparty45Builder setDrctnOrSd(Direction4Choice _drctnOrSd) {
			this.drctnOrSd = _drctnOrSd == null ? null : _drctnOrSd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradrLctn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradrLctn")
		@Override
		public Counterparty45.Counterparty45Builder setTradrLctn(String _tradrLctn) {
			this.tradrLctn = _tradrLctn == null ? null : _tradrLctn;
			return this;
		}
		
		@RosettaAttribute("bookgLctn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bookgLctn")
		@Override
		public Counterparty45.Counterparty45Builder setBookgLctn(String _bookgLctn) {
			this.bookgLctn = _bookgLctn == null ? null : _bookgLctn;
			return this;
		}
		
		@RosettaAttribute("rptgXmptn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rptgXmptn")
		@Override
		public Counterparty45.Counterparty45Builder setRptgXmptn(ReportingExemption1 _rptgXmptn) {
			this.rptgXmptn = _rptgXmptn == null ? null : _rptgXmptn.toBuilder();
			return this;
		}
		
		@Override
		public Counterparty45 build() {
			return new Counterparty45.Counterparty45Impl(this);
		}
		
		@Override
		public Counterparty45.Counterparty45Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty45.Counterparty45Builder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			if (ntr!=null && !ntr.prune().hasData()) ntr = null;
			if (drctnOrSd!=null && !drctnOrSd.prune().hasData()) drctnOrSd = null;
			if (rptgXmptn!=null && !rptgXmptn.prune().hasData()) rptgXmptn = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null && getId().hasData()) return true;
			if (getNtr()!=null && getNtr().hasData()) return true;
			if (getTradgCpcty()!=null) return true;
			if (getDrctnOrSd()!=null && getDrctnOrSd().hasData()) return true;
			if (getTradrLctn()!=null) return true;
			if (getBookgLctn()!=null) return true;
			if (getRptgXmptn()!=null && getRptgXmptn().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty45.Counterparty45Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Counterparty45.Counterparty45Builder o = (Counterparty45.Counterparty45Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(getNtr(), o.getNtr(), this::setNtr);
			merger.mergeRosetta(getDrctnOrSd(), o.getDrctnOrSd(), this::setDrctnOrSd);
			merger.mergeRosetta(getRptgXmptn(), o.getRptgXmptn(), this::setRptgXmptn);
			
			merger.mergeBasic(getTradgCpcty(), o.getTradgCpcty(), this::setTradgCpcty);
			merger.mergeBasic(getTradrLctn(), o.getTradrLctn(), this::setTradrLctn);
			merger.mergeBasic(getBookgLctn(), o.getBookgLctn(), this::setBookgLctn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty45 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(ntr, _that.getNtr())) return false;
			if (!Objects.equals(tradgCpcty, _that.getTradgCpcty())) return false;
			if (!Objects.equals(drctnOrSd, _that.getDrctnOrSd())) return false;
			if (!Objects.equals(tradrLctn, _that.getTradrLctn())) return false;
			if (!Objects.equals(bookgLctn, _that.getBookgLctn())) return false;
			if (!Objects.equals(rptgXmptn, _that.getRptgXmptn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (ntr != null ? ntr.hashCode() : 0);
			_result = 31 * _result + (tradgCpcty != null ? tradgCpcty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (drctnOrSd != null ? drctnOrSd.hashCode() : 0);
			_result = 31 * _result + (tradrLctn != null ? tradrLctn.hashCode() : 0);
			_result = 31 * _result + (bookgLctn != null ? bookgLctn.hashCode() : 0);
			_result = 31 * _result + (rptgXmptn != null ? rptgXmptn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty45Builder {" +
				"id=" + this.id + ", " +
				"ntr=" + this.ntr + ", " +
				"tradgCpcty=" + this.tradgCpcty + ", " +
				"drctnOrSd=" + this.drctnOrSd + ", " +
				"tradrLctn=" + this.tradrLctn + ", " +
				"bookgLctn=" + this.bookgLctn + ", " +
				"rptgXmptn=" + this.rptgXmptn +
			'}';
		}
	}
}
