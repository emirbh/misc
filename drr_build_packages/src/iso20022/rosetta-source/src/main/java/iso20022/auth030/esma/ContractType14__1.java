package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.ContractType14__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to contract attributes.
 * @version ${project.version}
 */
@RosettaDataType(value="ContractType14__1", builder=ContractType14__1.ContractType14__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ContractType14__1", model="iso20022", builder=ContractType14__1.ContractType14__1BuilderImpl.class, version="${project.version}")
public interface ContractType14__1 extends RosettaModelObject {

	ContractType14__1Meta metaData = new ContractType14__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Classification of information according to contract type.
	 */
	FinancialInstrumentContractType2Code getCtrctTp();
	/**
	 * Specifies the classification according to the asset class of the contract.
	 */
	ProductType4Code__1 getAsstClss();
	/**
	 * Specifies the classification of the derivative product.
	 */
	String getPdctClssfctn();
	/**
	 * Specifies the identification of the derivative product.
	 */
	SecurityIdentification46__1 getPdctId();
	/**
	 * Unique identification to identify the direct underlying instrument based on its type.
	 */
	SecurityIdentification41Choice__1 getUndrlygInstrm();
	/**
	 * Specifies the currency to be used for cash settlement of the transaction.   Usage: For multicurrency transactions that do not net, SettlementCurrency is to be considered as the first leg.
	 */
	CurrencyExchange23__1 getSttlmCcy();
	/**
	 * Specifies the currency second leg to be used for cash settlement of the transaction.
	 */
	CurrencyExchange23__1 getSttlmCcyScndLeg();
	/**
	 * Indicator whether the derivative is based on crypto-asset.  Usage: If the element is not present, the DerivativeBasedOnCryptoAsset is False.
	 */
	Boolean getDerivBasedOnCrptAsst();

	/*********************** Build Methods  ***********************/
	ContractType14__1 build();
	
	ContractType14__1.ContractType14__1Builder toBuilder();
	
	static ContractType14__1.ContractType14__1Builder builder() {
		return new ContractType14__1.ContractType14__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractType14__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractType14__1> getType() {
		return ContractType14__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ctrctTp"), FinancialInstrumentContractType2Code.class, getCtrctTp(), this);
		processor.processBasic(path.newSubPath("asstClss"), ProductType4Code__1.class, getAsstClss(), this);
		processor.processBasic(path.newSubPath("pdctClssfctn"), String.class, getPdctClssfctn(), this);
		processRosetta(path.newSubPath("pdctId"), processor, SecurityIdentification46__1.class, getPdctId());
		processRosetta(path.newSubPath("undrlygInstrm"), processor, SecurityIdentification41Choice__1.class, getUndrlygInstrm());
		processRosetta(path.newSubPath("sttlmCcy"), processor, CurrencyExchange23__1.class, getSttlmCcy());
		processRosetta(path.newSubPath("sttlmCcyScndLeg"), processor, CurrencyExchange23__1.class, getSttlmCcyScndLeg());
		processor.processBasic(path.newSubPath("derivBasedOnCrptAsst"), Boolean.class, getDerivBasedOnCrptAsst(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractType14__1Builder extends ContractType14__1, RosettaModelObjectBuilder {
		SecurityIdentification46__1.SecurityIdentification46__1Builder getOrCreatePdctId();
		@Override
		SecurityIdentification46__1.SecurityIdentification46__1Builder getPdctId();
		SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder getOrCreateUndrlygInstrm();
		@Override
		SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder getUndrlygInstrm();
		CurrencyExchange23__1.CurrencyExchange23__1Builder getOrCreateSttlmCcy();
		@Override
		CurrencyExchange23__1.CurrencyExchange23__1Builder getSttlmCcy();
		CurrencyExchange23__1.CurrencyExchange23__1Builder getOrCreateSttlmCcyScndLeg();
		@Override
		CurrencyExchange23__1.CurrencyExchange23__1Builder getSttlmCcyScndLeg();
		ContractType14__1.ContractType14__1Builder setCtrctTp(FinancialInstrumentContractType2Code ctrctTp);
		ContractType14__1.ContractType14__1Builder setAsstClss(ProductType4Code__1 asstClss);
		ContractType14__1.ContractType14__1Builder setPdctClssfctn(String pdctClssfctn);
		ContractType14__1.ContractType14__1Builder setPdctId(SecurityIdentification46__1 pdctId);
		ContractType14__1.ContractType14__1Builder setUndrlygInstrm(SecurityIdentification41Choice__1 undrlygInstrm);
		ContractType14__1.ContractType14__1Builder setSttlmCcy(CurrencyExchange23__1 sttlmCcy);
		ContractType14__1.ContractType14__1Builder setSttlmCcyScndLeg(CurrencyExchange23__1 sttlmCcyScndLeg);
		ContractType14__1.ContractType14__1Builder setDerivBasedOnCrptAsst(Boolean derivBasedOnCrptAsst);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ctrctTp"), FinancialInstrumentContractType2Code.class, getCtrctTp(), this);
			processor.processBasic(path.newSubPath("asstClss"), ProductType4Code__1.class, getAsstClss(), this);
			processor.processBasic(path.newSubPath("pdctClssfctn"), String.class, getPdctClssfctn(), this);
			processRosetta(path.newSubPath("pdctId"), processor, SecurityIdentification46__1.SecurityIdentification46__1Builder.class, getPdctId());
			processRosetta(path.newSubPath("undrlygInstrm"), processor, SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder.class, getUndrlygInstrm());
			processRosetta(path.newSubPath("sttlmCcy"), processor, CurrencyExchange23__1.CurrencyExchange23__1Builder.class, getSttlmCcy());
			processRosetta(path.newSubPath("sttlmCcyScndLeg"), processor, CurrencyExchange23__1.CurrencyExchange23__1Builder.class, getSttlmCcyScndLeg());
			processor.processBasic(path.newSubPath("derivBasedOnCrptAsst"), Boolean.class, getDerivBasedOnCrptAsst(), this);
		}
		

		ContractType14__1.ContractType14__1Builder prune();
	}

	/*********************** Immutable Implementation of ContractType14__1  ***********************/
	class ContractType14__1Impl implements ContractType14__1 {
		private final FinancialInstrumentContractType2Code ctrctTp;
		private final ProductType4Code__1 asstClss;
		private final String pdctClssfctn;
		private final SecurityIdentification46__1 pdctId;
		private final SecurityIdentification41Choice__1 undrlygInstrm;
		private final CurrencyExchange23__1 sttlmCcy;
		private final CurrencyExchange23__1 sttlmCcyScndLeg;
		private final Boolean derivBasedOnCrptAsst;
		
		protected ContractType14__1Impl(ContractType14__1.ContractType14__1Builder builder) {
			this.ctrctTp = builder.getCtrctTp();
			this.asstClss = builder.getAsstClss();
			this.pdctClssfctn = builder.getPdctClssfctn();
			this.pdctId = ofNullable(builder.getPdctId()).map(f->f.build()).orElse(null);
			this.undrlygInstrm = ofNullable(builder.getUndrlygInstrm()).map(f->f.build()).orElse(null);
			this.sttlmCcy = ofNullable(builder.getSttlmCcy()).map(f->f.build()).orElse(null);
			this.sttlmCcyScndLeg = ofNullable(builder.getSttlmCcyScndLeg()).map(f->f.build()).orElse(null);
			this.derivBasedOnCrptAsst = builder.getDerivBasedOnCrptAsst();
		}
		
		@Override
		@RosettaAttribute("ctrctTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrctTp")
		public FinancialInstrumentContractType2Code getCtrctTp() {
			return ctrctTp;
		}
		
		@Override
		@RosettaAttribute("asstClss")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("asstClss")
		public ProductType4Code__1 getAsstClss() {
			return asstClss;
		}
		
		@Override
		@RosettaAttribute("pdctClssfctn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pdctClssfctn")
		public String getPdctClssfctn() {
			return pdctClssfctn;
		}
		
		@Override
		@RosettaAttribute("pdctId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pdctId")
		public SecurityIdentification46__1 getPdctId() {
			return pdctId;
		}
		
		@Override
		@RosettaAttribute("undrlygInstrm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("undrlygInstrm")
		public SecurityIdentification41Choice__1 getUndrlygInstrm() {
			return undrlygInstrm;
		}
		
		@Override
		@RosettaAttribute("sttlmCcy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sttlmCcy")
		public CurrencyExchange23__1 getSttlmCcy() {
			return sttlmCcy;
		}
		
		@Override
		@RosettaAttribute("sttlmCcyScndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sttlmCcyScndLeg")
		public CurrencyExchange23__1 getSttlmCcyScndLeg() {
			return sttlmCcyScndLeg;
		}
		
		@Override
		@RosettaAttribute("derivBasedOnCrptAsst")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivBasedOnCrptAsst")
		public Boolean getDerivBasedOnCrptAsst() {
			return derivBasedOnCrptAsst;
		}
		
		@Override
		public ContractType14__1 build() {
			return this;
		}
		
		@Override
		public ContractType14__1.ContractType14__1Builder toBuilder() {
			ContractType14__1.ContractType14__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractType14__1.ContractType14__1Builder builder) {
			ofNullable(getCtrctTp()).ifPresent(builder::setCtrctTp);
			ofNullable(getAsstClss()).ifPresent(builder::setAsstClss);
			ofNullable(getPdctClssfctn()).ifPresent(builder::setPdctClssfctn);
			ofNullable(getPdctId()).ifPresent(builder::setPdctId);
			ofNullable(getUndrlygInstrm()).ifPresent(builder::setUndrlygInstrm);
			ofNullable(getSttlmCcy()).ifPresent(builder::setSttlmCcy);
			ofNullable(getSttlmCcyScndLeg()).ifPresent(builder::setSttlmCcyScndLeg);
			ofNullable(getDerivBasedOnCrptAsst()).ifPresent(builder::setDerivBasedOnCrptAsst);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractType14__1 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctTp, _that.getCtrctTp())) return false;
			if (!Objects.equals(asstClss, _that.getAsstClss())) return false;
			if (!Objects.equals(pdctClssfctn, _that.getPdctClssfctn())) return false;
			if (!Objects.equals(pdctId, _that.getPdctId())) return false;
			if (!Objects.equals(undrlygInstrm, _that.getUndrlygInstrm())) return false;
			if (!Objects.equals(sttlmCcy, _that.getSttlmCcy())) return false;
			if (!Objects.equals(sttlmCcyScndLeg, _that.getSttlmCcyScndLeg())) return false;
			if (!Objects.equals(derivBasedOnCrptAsst, _that.getDerivBasedOnCrptAsst())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctTp != null ? ctrctTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asstClss != null ? asstClss.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pdctClssfctn != null ? pdctClssfctn.hashCode() : 0);
			_result = 31 * _result + (pdctId != null ? pdctId.hashCode() : 0);
			_result = 31 * _result + (undrlygInstrm != null ? undrlygInstrm.hashCode() : 0);
			_result = 31 * _result + (sttlmCcy != null ? sttlmCcy.hashCode() : 0);
			_result = 31 * _result + (sttlmCcyScndLeg != null ? sttlmCcyScndLeg.hashCode() : 0);
			_result = 31 * _result + (derivBasedOnCrptAsst != null ? derivBasedOnCrptAsst.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractType14__1 {" +
				"ctrctTp=" + this.ctrctTp + ", " +
				"asstClss=" + this.asstClss + ", " +
				"pdctClssfctn=" + this.pdctClssfctn + ", " +
				"pdctId=" + this.pdctId + ", " +
				"undrlygInstrm=" + this.undrlygInstrm + ", " +
				"sttlmCcy=" + this.sttlmCcy + ", " +
				"sttlmCcyScndLeg=" + this.sttlmCcyScndLeg + ", " +
				"derivBasedOnCrptAsst=" + this.derivBasedOnCrptAsst +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractType14__1  ***********************/
	class ContractType14__1BuilderImpl implements ContractType14__1.ContractType14__1Builder {
	
		protected FinancialInstrumentContractType2Code ctrctTp;
		protected ProductType4Code__1 asstClss;
		protected String pdctClssfctn;
		protected SecurityIdentification46__1.SecurityIdentification46__1Builder pdctId;
		protected SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder undrlygInstrm;
		protected CurrencyExchange23__1.CurrencyExchange23__1Builder sttlmCcy;
		protected CurrencyExchange23__1.CurrencyExchange23__1Builder sttlmCcyScndLeg;
		protected Boolean derivBasedOnCrptAsst;
		
		@Override
		@RosettaAttribute("ctrctTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrctTp")
		public FinancialInstrumentContractType2Code getCtrctTp() {
			return ctrctTp;
		}
		
		@Override
		@RosettaAttribute("asstClss")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("asstClss")
		public ProductType4Code__1 getAsstClss() {
			return asstClss;
		}
		
		@Override
		@RosettaAttribute("pdctClssfctn")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pdctClssfctn")
		public String getPdctClssfctn() {
			return pdctClssfctn;
		}
		
		@Override
		@RosettaAttribute("pdctId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pdctId")
		public SecurityIdentification46__1.SecurityIdentification46__1Builder getPdctId() {
			return pdctId;
		}
		
		@Override
		public SecurityIdentification46__1.SecurityIdentification46__1Builder getOrCreatePdctId() {
			SecurityIdentification46__1.SecurityIdentification46__1Builder result;
			if (pdctId!=null) {
				result = pdctId;
			}
			else {
				result = pdctId = SecurityIdentification46__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("undrlygInstrm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("undrlygInstrm")
		public SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder getUndrlygInstrm() {
			return undrlygInstrm;
		}
		
		@Override
		public SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder getOrCreateUndrlygInstrm() {
			SecurityIdentification41Choice__1.SecurityIdentification41Choice__1Builder result;
			if (undrlygInstrm!=null) {
				result = undrlygInstrm;
			}
			else {
				result = undrlygInstrm = SecurityIdentification41Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sttlmCcy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sttlmCcy")
		public CurrencyExchange23__1.CurrencyExchange23__1Builder getSttlmCcy() {
			return sttlmCcy;
		}
		
		@Override
		public CurrencyExchange23__1.CurrencyExchange23__1Builder getOrCreateSttlmCcy() {
			CurrencyExchange23__1.CurrencyExchange23__1Builder result;
			if (sttlmCcy!=null) {
				result = sttlmCcy;
			}
			else {
				result = sttlmCcy = CurrencyExchange23__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sttlmCcyScndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sttlmCcyScndLeg")
		public CurrencyExchange23__1.CurrencyExchange23__1Builder getSttlmCcyScndLeg() {
			return sttlmCcyScndLeg;
		}
		
		@Override
		public CurrencyExchange23__1.CurrencyExchange23__1Builder getOrCreateSttlmCcyScndLeg() {
			CurrencyExchange23__1.CurrencyExchange23__1Builder result;
			if (sttlmCcyScndLeg!=null) {
				result = sttlmCcyScndLeg;
			}
			else {
				result = sttlmCcyScndLeg = CurrencyExchange23__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("derivBasedOnCrptAsst")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivBasedOnCrptAsst")
		public Boolean getDerivBasedOnCrptAsst() {
			return derivBasedOnCrptAsst;
		}
		
		@RosettaAttribute("ctrctTp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrctTp")
		@Override
		public ContractType14__1.ContractType14__1Builder setCtrctTp(FinancialInstrumentContractType2Code _ctrctTp) {
			this.ctrctTp = _ctrctTp == null ? null : _ctrctTp;
			return this;
		}
		
		@RosettaAttribute("asstClss")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("asstClss")
		@Override
		public ContractType14__1.ContractType14__1Builder setAsstClss(ProductType4Code__1 _asstClss) {
			this.asstClss = _asstClss == null ? null : _asstClss;
			return this;
		}
		
		@RosettaAttribute("pdctClssfctn")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pdctClssfctn")
		@Override
		public ContractType14__1.ContractType14__1Builder setPdctClssfctn(String _pdctClssfctn) {
			this.pdctClssfctn = _pdctClssfctn == null ? null : _pdctClssfctn;
			return this;
		}
		
		@RosettaAttribute("pdctId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pdctId")
		@Override
		public ContractType14__1.ContractType14__1Builder setPdctId(SecurityIdentification46__1 _pdctId) {
			this.pdctId = _pdctId == null ? null : _pdctId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("undrlygInstrm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("undrlygInstrm")
		@Override
		public ContractType14__1.ContractType14__1Builder setUndrlygInstrm(SecurityIdentification41Choice__1 _undrlygInstrm) {
			this.undrlygInstrm = _undrlygInstrm == null ? null : _undrlygInstrm.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sttlmCcy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sttlmCcy")
		@Override
		public ContractType14__1.ContractType14__1Builder setSttlmCcy(CurrencyExchange23__1 _sttlmCcy) {
			this.sttlmCcy = _sttlmCcy == null ? null : _sttlmCcy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sttlmCcyScndLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sttlmCcyScndLeg")
		@Override
		public ContractType14__1.ContractType14__1Builder setSttlmCcyScndLeg(CurrencyExchange23__1 _sttlmCcyScndLeg) {
			this.sttlmCcyScndLeg = _sttlmCcyScndLeg == null ? null : _sttlmCcyScndLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("derivBasedOnCrptAsst")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("derivBasedOnCrptAsst")
		@Override
		public ContractType14__1.ContractType14__1Builder setDerivBasedOnCrptAsst(Boolean _derivBasedOnCrptAsst) {
			this.derivBasedOnCrptAsst = _derivBasedOnCrptAsst == null ? null : _derivBasedOnCrptAsst;
			return this;
		}
		
		@Override
		public ContractType14__1 build() {
			return new ContractType14__1.ContractType14__1Impl(this);
		}
		
		@Override
		public ContractType14__1.ContractType14__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractType14__1.ContractType14__1Builder prune() {
			if (pdctId!=null && !pdctId.prune().hasData()) pdctId = null;
			if (undrlygInstrm!=null && !undrlygInstrm.prune().hasData()) undrlygInstrm = null;
			if (sttlmCcy!=null && !sttlmCcy.prune().hasData()) sttlmCcy = null;
			if (sttlmCcyScndLeg!=null && !sttlmCcyScndLeg.prune().hasData()) sttlmCcyScndLeg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtrctTp()!=null) return true;
			if (getAsstClss()!=null) return true;
			if (getPdctClssfctn()!=null) return true;
			if (getPdctId()!=null && getPdctId().hasData()) return true;
			if (getUndrlygInstrm()!=null && getUndrlygInstrm().hasData()) return true;
			if (getSttlmCcy()!=null && getSttlmCcy().hasData()) return true;
			if (getSttlmCcyScndLeg()!=null && getSttlmCcyScndLeg().hasData()) return true;
			if (getDerivBasedOnCrptAsst()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractType14__1.ContractType14__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractType14__1.ContractType14__1Builder o = (ContractType14__1.ContractType14__1Builder) other;
			
			merger.mergeRosetta(getPdctId(), o.getPdctId(), this::setPdctId);
			merger.mergeRosetta(getUndrlygInstrm(), o.getUndrlygInstrm(), this::setUndrlygInstrm);
			merger.mergeRosetta(getSttlmCcy(), o.getSttlmCcy(), this::setSttlmCcy);
			merger.mergeRosetta(getSttlmCcyScndLeg(), o.getSttlmCcyScndLeg(), this::setSttlmCcyScndLeg);
			
			merger.mergeBasic(getCtrctTp(), o.getCtrctTp(), this::setCtrctTp);
			merger.mergeBasic(getAsstClss(), o.getAsstClss(), this::setAsstClss);
			merger.mergeBasic(getPdctClssfctn(), o.getPdctClssfctn(), this::setPdctClssfctn);
			merger.mergeBasic(getDerivBasedOnCrptAsst(), o.getDerivBasedOnCrptAsst(), this::setDerivBasedOnCrptAsst);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractType14__1 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctTp, _that.getCtrctTp())) return false;
			if (!Objects.equals(asstClss, _that.getAsstClss())) return false;
			if (!Objects.equals(pdctClssfctn, _that.getPdctClssfctn())) return false;
			if (!Objects.equals(pdctId, _that.getPdctId())) return false;
			if (!Objects.equals(undrlygInstrm, _that.getUndrlygInstrm())) return false;
			if (!Objects.equals(sttlmCcy, _that.getSttlmCcy())) return false;
			if (!Objects.equals(sttlmCcyScndLeg, _that.getSttlmCcyScndLeg())) return false;
			if (!Objects.equals(derivBasedOnCrptAsst, _that.getDerivBasedOnCrptAsst())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctTp != null ? ctrctTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asstClss != null ? asstClss.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pdctClssfctn != null ? pdctClssfctn.hashCode() : 0);
			_result = 31 * _result + (pdctId != null ? pdctId.hashCode() : 0);
			_result = 31 * _result + (undrlygInstrm != null ? undrlygInstrm.hashCode() : 0);
			_result = 31 * _result + (sttlmCcy != null ? sttlmCcy.hashCode() : 0);
			_result = 31 * _result + (sttlmCcyScndLeg != null ? sttlmCcyScndLeg.hashCode() : 0);
			_result = 31 * _result + (derivBasedOnCrptAsst != null ? derivBasedOnCrptAsst.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractType14__1Builder {" +
				"ctrctTp=" + this.ctrctTp + ", " +
				"asstClss=" + this.asstClss + ", " +
				"pdctClssfctn=" + this.pdctClssfctn + ", " +
				"pdctId=" + this.pdctId + ", " +
				"undrlygInstrm=" + this.undrlygInstrm + ", " +
				"sttlmCcy=" + this.sttlmCcy + ", " +
				"sttlmCcyScndLeg=" + this.sttlmCcyScndLeg + ", " +
				"derivBasedOnCrptAsst=" + this.derivBasedOnCrptAsst +
			'}';
		}
	}
}
