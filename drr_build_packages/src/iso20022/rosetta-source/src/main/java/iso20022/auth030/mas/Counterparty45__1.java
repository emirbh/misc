package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.Counterparty45__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Counterparty45__1", builder=Counterparty45__1.Counterparty45__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Counterparty45__1", model="iso20022", builder=Counterparty45__1.Counterparty45__1BuilderImpl.class, version="${project.version}")
public interface Counterparty45__1 extends RosettaModelObject {

	Counterparty45__1Meta metaData = new Counterparty45__1Meta();

	/*********************** Getter Methods  ***********************/
	PartyIdentification248Choice__1 getId();
	TradingCapacity7Code getTradgCpcty();
	Direction4Choice getDrctnOrSd();
	String getTradrLctn();
	String getBookgLctn();

	/*********************** Build Methods  ***********************/
	Counterparty45__1 build();
	
	Counterparty45__1.Counterparty45__1Builder toBuilder();
	
	static Counterparty45__1.Counterparty45__1Builder builder() {
		return new Counterparty45__1.Counterparty45__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Counterparty45__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Counterparty45__1> getType() {
		return Counterparty45__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, PartyIdentification248Choice__1.class, getId());
		processor.processBasic(path.newSubPath("tradgCpcty"), TradingCapacity7Code.class, getTradgCpcty(), this);
		processRosetta(path.newSubPath("drctnOrSd"), processor, Direction4Choice.class, getDrctnOrSd());
		processor.processBasic(path.newSubPath("tradrLctn"), String.class, getTradrLctn(), this);
		processor.processBasic(path.newSubPath("bookgLctn"), String.class, getBookgLctn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Counterparty45__1Builder extends Counterparty45__1, RosettaModelObjectBuilder {
		PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder getOrCreateId();
		@Override
		PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder getId();
		Direction4Choice.Direction4ChoiceBuilder getOrCreateDrctnOrSd();
		@Override
		Direction4Choice.Direction4ChoiceBuilder getDrctnOrSd();
		Counterparty45__1.Counterparty45__1Builder setId(PartyIdentification248Choice__1 id);
		Counterparty45__1.Counterparty45__1Builder setTradgCpcty(TradingCapacity7Code tradgCpcty);
		Counterparty45__1.Counterparty45__1Builder setDrctnOrSd(Direction4Choice drctnOrSd);
		Counterparty45__1.Counterparty45__1Builder setTradrLctn(String tradrLctn);
		Counterparty45__1.Counterparty45__1Builder setBookgLctn(String bookgLctn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder.class, getId());
			processor.processBasic(path.newSubPath("tradgCpcty"), TradingCapacity7Code.class, getTradgCpcty(), this);
			processRosetta(path.newSubPath("drctnOrSd"), processor, Direction4Choice.Direction4ChoiceBuilder.class, getDrctnOrSd());
			processor.processBasic(path.newSubPath("tradrLctn"), String.class, getTradrLctn(), this);
			processor.processBasic(path.newSubPath("bookgLctn"), String.class, getBookgLctn(), this);
		}
		

		Counterparty45__1.Counterparty45__1Builder prune();
	}

	/*********************** Immutable Implementation of Counterparty45__1  ***********************/
	class Counterparty45__1Impl implements Counterparty45__1 {
		private final PartyIdentification248Choice__1 id;
		private final TradingCapacity7Code tradgCpcty;
		private final Direction4Choice drctnOrSd;
		private final String tradrLctn;
		private final String bookgLctn;
		
		protected Counterparty45__1Impl(Counterparty45__1.Counterparty45__1Builder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.tradgCpcty = builder.getTradgCpcty();
			this.drctnOrSd = ofNullable(builder.getDrctnOrSd()).map(f->f.build()).orElse(null);
			this.tradrLctn = builder.getTradrLctn();
			this.bookgLctn = builder.getBookgLctn();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public PartyIdentification248Choice__1 getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("tradgCpcty")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@Required
		@RuneAttribute("tradrLctn")
		public String getTradrLctn() {
			return tradrLctn;
		}
		
		@Override
		@RosettaAttribute("bookgLctn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("bookgLctn")
		public String getBookgLctn() {
			return bookgLctn;
		}
		
		@Override
		public Counterparty45__1 build() {
			return this;
		}
		
		@Override
		public Counterparty45__1.Counterparty45__1Builder toBuilder() {
			Counterparty45__1.Counterparty45__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Counterparty45__1.Counterparty45__1Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getTradgCpcty()).ifPresent(builder::setTradgCpcty);
			ofNullable(getDrctnOrSd()).ifPresent(builder::setDrctnOrSd);
			ofNullable(getTradrLctn()).ifPresent(builder::setTradrLctn);
			ofNullable(getBookgLctn()).ifPresent(builder::setBookgLctn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty45__1 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(tradgCpcty, _that.getTradgCpcty())) return false;
			if (!Objects.equals(drctnOrSd, _that.getDrctnOrSd())) return false;
			if (!Objects.equals(tradrLctn, _that.getTradrLctn())) return false;
			if (!Objects.equals(bookgLctn, _that.getBookgLctn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (tradgCpcty != null ? tradgCpcty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (drctnOrSd != null ? drctnOrSd.hashCode() : 0);
			_result = 31 * _result + (tradrLctn != null ? tradrLctn.hashCode() : 0);
			_result = 31 * _result + (bookgLctn != null ? bookgLctn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty45__1 {" +
				"id=" + this.id + ", " +
				"tradgCpcty=" + this.tradgCpcty + ", " +
				"drctnOrSd=" + this.drctnOrSd + ", " +
				"tradrLctn=" + this.tradrLctn + ", " +
				"bookgLctn=" + this.bookgLctn +
			'}';
		}
	}

	/*********************** Builder Implementation of Counterparty45__1  ***********************/
	class Counterparty45__1BuilderImpl implements Counterparty45__1.Counterparty45__1Builder {
	
		protected PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder id;
		protected TradingCapacity7Code tradgCpcty;
		protected Direction4Choice.Direction4ChoiceBuilder drctnOrSd;
		protected String tradrLctn;
		protected String bookgLctn;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder getId() {
			return id;
		}
		
		@Override
		public PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder getOrCreateId() {
			PartyIdentification248Choice__1.PartyIdentification248Choice__1Builder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = PartyIdentification248Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradgCpcty")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@Required
		@RuneAttribute("tradrLctn")
		public String getTradrLctn() {
			return tradrLctn;
		}
		
		@Override
		@RosettaAttribute("bookgLctn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("bookgLctn")
		public String getBookgLctn() {
			return bookgLctn;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public Counterparty45__1.Counterparty45__1Builder setId(PartyIdentification248Choice__1 _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradgCpcty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradgCpcty")
		@Override
		public Counterparty45__1.Counterparty45__1Builder setTradgCpcty(TradingCapacity7Code _tradgCpcty) {
			this.tradgCpcty = _tradgCpcty == null ? null : _tradgCpcty;
			return this;
		}
		
		@RosettaAttribute("drctnOrSd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("drctnOrSd")
		@Override
		public Counterparty45__1.Counterparty45__1Builder setDrctnOrSd(Direction4Choice _drctnOrSd) {
			this.drctnOrSd = _drctnOrSd == null ? null : _drctnOrSd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradrLctn")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradrLctn")
		@Override
		public Counterparty45__1.Counterparty45__1Builder setTradrLctn(String _tradrLctn) {
			this.tradrLctn = _tradrLctn == null ? null : _tradrLctn;
			return this;
		}
		
		@RosettaAttribute("bookgLctn")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("bookgLctn")
		@Override
		public Counterparty45__1.Counterparty45__1Builder setBookgLctn(String _bookgLctn) {
			this.bookgLctn = _bookgLctn == null ? null : _bookgLctn;
			return this;
		}
		
		@Override
		public Counterparty45__1 build() {
			return new Counterparty45__1.Counterparty45__1Impl(this);
		}
		
		@Override
		public Counterparty45__1.Counterparty45__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty45__1.Counterparty45__1Builder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			if (drctnOrSd!=null && !drctnOrSd.prune().hasData()) drctnOrSd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null && getId().hasData()) return true;
			if (getTradgCpcty()!=null) return true;
			if (getDrctnOrSd()!=null && getDrctnOrSd().hasData()) return true;
			if (getTradrLctn()!=null) return true;
			if (getBookgLctn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty45__1.Counterparty45__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Counterparty45__1.Counterparty45__1Builder o = (Counterparty45__1.Counterparty45__1Builder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(getDrctnOrSd(), o.getDrctnOrSd(), this::setDrctnOrSd);
			
			merger.mergeBasic(getTradgCpcty(), o.getTradgCpcty(), this::setTradgCpcty);
			merger.mergeBasic(getTradrLctn(), o.getTradrLctn(), this::setTradrLctn);
			merger.mergeBasic(getBookgLctn(), o.getBookgLctn(), this::setBookgLctn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty45__1 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(tradgCpcty, _that.getTradgCpcty())) return false;
			if (!Objects.equals(drctnOrSd, _that.getDrctnOrSd())) return false;
			if (!Objects.equals(tradrLctn, _that.getTradrLctn())) return false;
			if (!Objects.equals(bookgLctn, _that.getBookgLctn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (tradgCpcty != null ? tradgCpcty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (drctnOrSd != null ? drctnOrSd.hashCode() : 0);
			_result = 31 * _result + (tradrLctn != null ? tradrLctn.hashCode() : 0);
			_result = 31 * _result + (bookgLctn != null ? bookgLctn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty45__1Builder {" +
				"id=" + this.id + ", " +
				"tradgCpcty=" + this.tradgCpcty + ", " +
				"drctnOrSd=" + this.drctnOrSd + ", " +
				"tradrLctn=" + this.tradrLctn + ", " +
				"bookgLctn=" + this.bookgLctn +
			'}';
		}
	}
}
