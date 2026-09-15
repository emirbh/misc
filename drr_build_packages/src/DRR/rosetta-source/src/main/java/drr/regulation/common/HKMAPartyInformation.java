package drr.regulation.common;

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
import drr.regulation.common.meta.HKMAPartyInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Enriched party information required for reporting a transaction under HKMA.
 * @version 7.7.0
 */
@RosettaDataType(value="HKMAPartyInformation", builder=HKMAPartyInformation.HKMAPartyInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="HKMAPartyInformation", model="drr", builder=HKMAPartyInformation.HKMAPartyInformationBuilderImpl.class, version="7.7.0")
public interface HKMAPartyInformation extends RosettaModelObject {

	HKMAPartyInformationMeta metaData = new HKMAPartyInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the nature of the counterparty.
	 */
	NatureOfPartyEnum getNatureOfParty();
	/**
	 * Specifies whether the portfolio contains non reported transactions.
	 */
	Boolean getNonReportedTradePortfolio();
	/**
	 * Specifies the corporate sector of the counterparty.
	 */
	CorporateSector getCorporateSector();

	/*********************** Build Methods  ***********************/
	HKMAPartyInformation build();
	
	HKMAPartyInformation.HKMAPartyInformationBuilder toBuilder();
	
	static HKMAPartyInformation.HKMAPartyInformationBuilder builder() {
		return new HKMAPartyInformation.HKMAPartyInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends HKMAPartyInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends HKMAPartyInformation> getType() {
		return HKMAPartyInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("natureOfParty"), NatureOfPartyEnum.class, getNatureOfParty(), this);
		processor.processBasic(path.newSubPath("nonReportedTradePortfolio"), Boolean.class, getNonReportedTradePortfolio(), this);
		processRosetta(path.newSubPath("corporateSector"), processor, CorporateSector.class, getCorporateSector());
	}
	

	/*********************** Builder Interface  ***********************/
	interface HKMAPartyInformationBuilder extends HKMAPartyInformation, RosettaModelObjectBuilder {
		CorporateSector.CorporateSectorBuilder getOrCreateCorporateSector();
		@Override
		CorporateSector.CorporateSectorBuilder getCorporateSector();
		HKMAPartyInformation.HKMAPartyInformationBuilder setNatureOfParty(NatureOfPartyEnum natureOfParty);
		HKMAPartyInformation.HKMAPartyInformationBuilder setNonReportedTradePortfolio(Boolean nonReportedTradePortfolio);
		HKMAPartyInformation.HKMAPartyInformationBuilder setCorporateSector(CorporateSector corporateSector);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("natureOfParty"), NatureOfPartyEnum.class, getNatureOfParty(), this);
			processor.processBasic(path.newSubPath("nonReportedTradePortfolio"), Boolean.class, getNonReportedTradePortfolio(), this);
			processRosetta(path.newSubPath("corporateSector"), processor, CorporateSector.CorporateSectorBuilder.class, getCorporateSector());
		}
		

		HKMAPartyInformation.HKMAPartyInformationBuilder prune();
	}

	/*********************** Immutable Implementation of HKMAPartyInformation  ***********************/
	class HKMAPartyInformationImpl implements HKMAPartyInformation {
		private final NatureOfPartyEnum natureOfParty;
		private final Boolean nonReportedTradePortfolio;
		private final CorporateSector corporateSector;
		
		protected HKMAPartyInformationImpl(HKMAPartyInformation.HKMAPartyInformationBuilder builder) {
			this.natureOfParty = builder.getNatureOfParty();
			this.nonReportedTradePortfolio = builder.getNonReportedTradePortfolio();
			this.corporateSector = ofNullable(builder.getCorporateSector()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("natureOfParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("natureOfParty")
		public NatureOfPartyEnum getNatureOfParty() {
			return natureOfParty;
		}
		
		@Override
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		public Boolean getNonReportedTradePortfolio() {
			return nonReportedTradePortfolio;
		}
		
		@Override
		@RosettaAttribute("corporateSector")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("corporateSector")
		public CorporateSector getCorporateSector() {
			return corporateSector;
		}
		
		@Override
		public HKMAPartyInformation build() {
			return this;
		}
		
		@Override
		public HKMAPartyInformation.HKMAPartyInformationBuilder toBuilder() {
			HKMAPartyInformation.HKMAPartyInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(HKMAPartyInformation.HKMAPartyInformationBuilder builder) {
			ofNullable(getNatureOfParty()).ifPresent(builder::setNatureOfParty);
			ofNullable(getNonReportedTradePortfolio()).ifPresent(builder::setNonReportedTradePortfolio);
			ofNullable(getCorporateSector()).ifPresent(builder::setCorporateSector);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HKMAPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(natureOfParty, _that.getNatureOfParty())) return false;
			if (!Objects.equals(nonReportedTradePortfolio, _that.getNonReportedTradePortfolio())) return false;
			if (!Objects.equals(corporateSector, _that.getCorporateSector())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (natureOfParty != null ? natureOfParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nonReportedTradePortfolio != null ? nonReportedTradePortfolio.hashCode() : 0);
			_result = 31 * _result + (corporateSector != null ? corporateSector.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HKMAPartyInformation {" +
				"natureOfParty=" + this.natureOfParty + ", " +
				"nonReportedTradePortfolio=" + this.nonReportedTradePortfolio + ", " +
				"corporateSector=" + this.corporateSector +
			'}';
		}
	}

	/*********************** Builder Implementation of HKMAPartyInformation  ***********************/
	class HKMAPartyInformationBuilderImpl implements HKMAPartyInformation.HKMAPartyInformationBuilder {
	
		protected NatureOfPartyEnum natureOfParty;
		protected Boolean nonReportedTradePortfolio;
		protected CorporateSector.CorporateSectorBuilder corporateSector;
		
		@Override
		@RosettaAttribute("natureOfParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("natureOfParty")
		public NatureOfPartyEnum getNatureOfParty() {
			return natureOfParty;
		}
		
		@Override
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		public Boolean getNonReportedTradePortfolio() {
			return nonReportedTradePortfolio;
		}
		
		@Override
		@RosettaAttribute("corporateSector")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("corporateSector")
		public CorporateSector.CorporateSectorBuilder getCorporateSector() {
			return corporateSector;
		}
		
		@Override
		public CorporateSector.CorporateSectorBuilder getOrCreateCorporateSector() {
			CorporateSector.CorporateSectorBuilder result;
			if (corporateSector!=null) {
				result = corporateSector;
			}
			else {
				result = corporateSector = CorporateSector.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("natureOfParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("natureOfParty")
		@Override
		public HKMAPartyInformation.HKMAPartyInformationBuilder setNatureOfParty(NatureOfPartyEnum _natureOfParty) {
			this.natureOfParty = _natureOfParty == null ? null : _natureOfParty;
			return this;
		}
		
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		@Override
		public HKMAPartyInformation.HKMAPartyInformationBuilder setNonReportedTradePortfolio(Boolean _nonReportedTradePortfolio) {
			this.nonReportedTradePortfolio = _nonReportedTradePortfolio == null ? null : _nonReportedTradePortfolio;
			return this;
		}
		
		@RosettaAttribute("corporateSector")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("corporateSector")
		@Override
		public HKMAPartyInformation.HKMAPartyInformationBuilder setCorporateSector(CorporateSector _corporateSector) {
			this.corporateSector = _corporateSector == null ? null : _corporateSector.toBuilder();
			return this;
		}
		
		@Override
		public HKMAPartyInformation build() {
			return new HKMAPartyInformation.HKMAPartyInformationImpl(this);
		}
		
		@Override
		public HKMAPartyInformation.HKMAPartyInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HKMAPartyInformation.HKMAPartyInformationBuilder prune() {
			if (corporateSector!=null && !corporateSector.prune().hasData()) corporateSector = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNatureOfParty()!=null) return true;
			if (getNonReportedTradePortfolio()!=null) return true;
			if (getCorporateSector()!=null && getCorporateSector().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HKMAPartyInformation.HKMAPartyInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			HKMAPartyInformation.HKMAPartyInformationBuilder o = (HKMAPartyInformation.HKMAPartyInformationBuilder) other;
			
			merger.mergeRosetta(getCorporateSector(), o.getCorporateSector(), this::setCorporateSector);
			
			merger.mergeBasic(getNatureOfParty(), o.getNatureOfParty(), this::setNatureOfParty);
			merger.mergeBasic(getNonReportedTradePortfolio(), o.getNonReportedTradePortfolio(), this::setNonReportedTradePortfolio);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HKMAPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(natureOfParty, _that.getNatureOfParty())) return false;
			if (!Objects.equals(nonReportedTradePortfolio, _that.getNonReportedTradePortfolio())) return false;
			if (!Objects.equals(corporateSector, _that.getCorporateSector())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (natureOfParty != null ? natureOfParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nonReportedTradePortfolio != null ? nonReportedTradePortfolio.hashCode() : 0);
			_result = 31 * _result + (corporateSector != null ? corporateSector.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HKMAPartyInformationBuilder {" +
				"natureOfParty=" + this.natureOfParty + ", " +
				"nonReportedTradePortfolio=" + this.nonReportedTradePortfolio + ", " +
				"corporateSector=" + this.corporateSector +
			'}';
		}
	}
}
