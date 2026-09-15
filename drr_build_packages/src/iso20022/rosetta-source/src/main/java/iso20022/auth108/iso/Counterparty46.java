package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.Counterparty46Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to counterparty identification.
 * @version ${project.version}
 */
@RosettaDataType(value="Counterparty46", builder=Counterparty46.Counterparty46BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Counterparty46", model="iso20022", builder=Counterparty46.Counterparty46BuilderImpl.class, version="${project.version}")
public interface Counterparty46 extends RosettaModelObject {

	Counterparty46Meta metaData = new Counterparty46Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates if the counterparty is a legal entity or a natural person.
	 */
	PartyIdentification248Choice getIdTp();
	/**
	 * Indicates if the counterparty is a central counterparty, a financial, non-financial counterparty or other type of counterparty in accordance with regulation.
	 */
	CounterpartyTradeNature15Choice getNtr();
	/**
	 * Indicator of whether the counterparty 2 has the reporting obligation (irrespective of who is responsible and legally liable for its reporting).    Usage: If the element is not present, the ReportingObligation is False.
	 */
	Boolean getRptgOblgtn();

	/*********************** Build Methods  ***********************/
	Counterparty46 build();
	
	Counterparty46.Counterparty46Builder toBuilder();
	
	static Counterparty46.Counterparty46Builder builder() {
		return new Counterparty46.Counterparty46BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Counterparty46> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Counterparty46> getType() {
		return Counterparty46.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("idTp"), processor, PartyIdentification248Choice.class, getIdTp());
		processRosetta(path.newSubPath("ntr"), processor, CounterpartyTradeNature15Choice.class, getNtr());
		processor.processBasic(path.newSubPath("rptgOblgtn"), Boolean.class, getRptgOblgtn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Counterparty46Builder extends Counterparty46, RosettaModelObjectBuilder {
		PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getOrCreateIdTp();
		@Override
		PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getIdTp();
		CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder getOrCreateNtr();
		@Override
		CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder getNtr();
		Counterparty46.Counterparty46Builder setIdTp(PartyIdentification248Choice idTp);
		Counterparty46.Counterparty46Builder setNtr(CounterpartyTradeNature15Choice ntr);
		Counterparty46.Counterparty46Builder setRptgOblgtn(Boolean rptgOblgtn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("idTp"), processor, PartyIdentification248Choice.PartyIdentification248ChoiceBuilder.class, getIdTp());
			processRosetta(path.newSubPath("ntr"), processor, CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder.class, getNtr());
			processor.processBasic(path.newSubPath("rptgOblgtn"), Boolean.class, getRptgOblgtn(), this);
		}
		

		Counterparty46.Counterparty46Builder prune();
	}

	/*********************** Immutable Implementation of Counterparty46  ***********************/
	class Counterparty46Impl implements Counterparty46 {
		private final PartyIdentification248Choice idTp;
		private final CounterpartyTradeNature15Choice ntr;
		private final Boolean rptgOblgtn;
		
		protected Counterparty46Impl(Counterparty46.Counterparty46Builder builder) {
			this.idTp = ofNullable(builder.getIdTp()).map(f->f.build()).orElse(null);
			this.ntr = ofNullable(builder.getNtr()).map(f->f.build()).orElse(null);
			this.rptgOblgtn = builder.getRptgOblgtn();
		}
		
		@Override
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("idTp")
		public PartyIdentification248Choice getIdTp() {
			return idTp;
		}
		
		@Override
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntr")
		public CounterpartyTradeNature15Choice getNtr() {
			return ntr;
		}
		
		@Override
		@RosettaAttribute("rptgOblgtn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptgOblgtn")
		public Boolean getRptgOblgtn() {
			return rptgOblgtn;
		}
		
		@Override
		public Counterparty46 build() {
			return this;
		}
		
		@Override
		public Counterparty46.Counterparty46Builder toBuilder() {
			Counterparty46.Counterparty46Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Counterparty46.Counterparty46Builder builder) {
			ofNullable(getIdTp()).ifPresent(builder::setIdTp);
			ofNullable(getNtr()).ifPresent(builder::setNtr);
			ofNullable(getRptgOblgtn()).ifPresent(builder::setRptgOblgtn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty46 _that = getType().cast(o);
		
			if (!Objects.equals(idTp, _that.getIdTp())) return false;
			if (!Objects.equals(ntr, _that.getNtr())) return false;
			if (!Objects.equals(rptgOblgtn, _that.getRptgOblgtn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (idTp != null ? idTp.hashCode() : 0);
			_result = 31 * _result + (ntr != null ? ntr.hashCode() : 0);
			_result = 31 * _result + (rptgOblgtn != null ? rptgOblgtn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty46 {" +
				"idTp=" + this.idTp + ", " +
				"ntr=" + this.ntr + ", " +
				"rptgOblgtn=" + this.rptgOblgtn +
			'}';
		}
	}

	/*********************** Builder Implementation of Counterparty46  ***********************/
	class Counterparty46BuilderImpl implements Counterparty46.Counterparty46Builder {
	
		protected PartyIdentification248Choice.PartyIdentification248ChoiceBuilder idTp;
		protected CounterpartyTradeNature15Choice.CounterpartyTradeNature15ChoiceBuilder ntr;
		protected Boolean rptgOblgtn;
		
		@Override
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("idTp")
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getIdTp() {
			return idTp;
		}
		
		@Override
		public PartyIdentification248Choice.PartyIdentification248ChoiceBuilder getOrCreateIdTp() {
			PartyIdentification248Choice.PartyIdentification248ChoiceBuilder result;
			if (idTp!=null) {
				result = idTp;
			}
			else {
				result = idTp = PartyIdentification248Choice.builder();
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
		@RosettaAttribute("rptgOblgtn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptgOblgtn")
		public Boolean getRptgOblgtn() {
			return rptgOblgtn;
		}
		
		@RosettaAttribute("idTp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("idTp")
		@Override
		public Counterparty46.Counterparty46Builder setIdTp(PartyIdentification248Choice _idTp) {
			this.idTp = _idTp == null ? null : _idTp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntr")
		@Override
		public Counterparty46.Counterparty46Builder setNtr(CounterpartyTradeNature15Choice _ntr) {
			this.ntr = _ntr == null ? null : _ntr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rptgOblgtn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rptgOblgtn")
		@Override
		public Counterparty46.Counterparty46Builder setRptgOblgtn(Boolean _rptgOblgtn) {
			this.rptgOblgtn = _rptgOblgtn == null ? null : _rptgOblgtn;
			return this;
		}
		
		@Override
		public Counterparty46 build() {
			return new Counterparty46.Counterparty46Impl(this);
		}
		
		@Override
		public Counterparty46.Counterparty46Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty46.Counterparty46Builder prune() {
			if (idTp!=null && !idTp.prune().hasData()) idTp = null;
			if (ntr!=null && !ntr.prune().hasData()) ntr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdTp()!=null && getIdTp().hasData()) return true;
			if (getNtr()!=null && getNtr().hasData()) return true;
			if (getRptgOblgtn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Counterparty46.Counterparty46Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Counterparty46.Counterparty46Builder o = (Counterparty46.Counterparty46Builder) other;
			
			merger.mergeRosetta(getIdTp(), o.getIdTp(), this::setIdTp);
			merger.mergeRosetta(getNtr(), o.getNtr(), this::setNtr);
			
			merger.mergeBasic(getRptgOblgtn(), o.getRptgOblgtn(), this::setRptgOblgtn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Counterparty46 _that = getType().cast(o);
		
			if (!Objects.equals(idTp, _that.getIdTp())) return false;
			if (!Objects.equals(ntr, _that.getNtr())) return false;
			if (!Objects.equals(rptgOblgtn, _that.getRptgOblgtn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (idTp != null ? idTp.hashCode() : 0);
			_result = 31 * _result + (ntr != null ? ntr.hashCode() : 0);
			_result = 31 * _result + (rptgOblgtn != null ? rptgOblgtn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Counterparty46Builder {" +
				"idTp=" + this.idTp + ", " +
				"ntr=" + this.ntr + ", " +
				"rptgOblgtn=" + this.rptgOblgtn +
			'}';
		}
	}
}
