package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CalculationAndTimingMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Calculation, Valuation and Timing terms specific to the agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="CalculationAndTiming", builder=CalculationAndTiming.CalculationAndTimingBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CalculationAndTiming", model="cdm", builder=CalculationAndTiming.CalculationAndTimingBuilderImpl.class, version="6.23.0")
public interface CalculationAndTiming extends RosettaModelObject {

	CalculationAndTimingMeta metaData = new CalculationAndTimingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The calculation agent terms applicable to the agreement.
	 */
	CalculationAgentTerms getCalculationAgentTerms();
	/**
	 * The specification of bespoke Calculation Date terms for the purposes of Initial or Variation Margin by the parties to the agreement.
	 */
	BespokeCalculationDate getBespokeCalculationDate();
	/**
	 * Bespoke terms to describe the time as of which such party (or the Calculation Agent (IM) (if applicale)) computes its end of day valuations of derivatives transactions.
	 */
	BespokeCalculationTime getBespokeCalculationTime();
	/**
	 * The specified location where the credit exposure will be calculated by the respective parties.
	 */
	CalculationDateLocation getCalculationDateLocation();
	/**
	 * The time by which a demand for the Transfer of Eligible Credit Support (IM) or Posted Credit Support (IM) needs to be made in order for the transfer to take place in accordance with the Transfer Timing provisions.
	 */
	NotificationTime getNotificationTime();
	/**
	 * The bespoke Collateral Valuation Agent terms applicable to the agreement.
	 */
	CollateralValuationAgent getCollateralValuationAgent();
	/**
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "4" * clause "(b)(i)"
	 *
	 * Provision 
	 *
	 */
	String getCashSettlementDay();
	/**
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "12"
	 *
	 * Provision 
	 *
	 */
	String getSecuritiesSettlementDay();
	/**
	 * Details of the days on which calculations are to be made to determine the Delivery Amount and/or Return Amount.
	 */
	LegacyValuationDate getLegacyValuationDate();
	/**
	 * The time by which the value of the collateral and obligations to transfer or return collateral are to be calculated relative to the Valuation Date.
	 */
	LegacyValuationTime getLegacyValuationTime();
	/**
	 * Details of the party calculating the value of collateral to be delivered or returned.
	 */
	LegacyValuationAgent getLegacyValuationAgent();

	/*********************** Build Methods  ***********************/
	CalculationAndTiming build();
	
	CalculationAndTiming.CalculationAndTimingBuilder toBuilder();
	
	static CalculationAndTiming.CalculationAndTimingBuilder builder() {
		return new CalculationAndTiming.CalculationAndTimingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationAndTiming> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationAndTiming> getType() {
		return CalculationAndTiming.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationAgentTerms"), processor, CalculationAgentTerms.class, getCalculationAgentTerms());
		processRosetta(path.newSubPath("bespokeCalculationDate"), processor, BespokeCalculationDate.class, getBespokeCalculationDate());
		processRosetta(path.newSubPath("bespokeCalculationTime"), processor, BespokeCalculationTime.class, getBespokeCalculationTime());
		processRosetta(path.newSubPath("calculationDateLocation"), processor, CalculationDateLocation.class, getCalculationDateLocation());
		processRosetta(path.newSubPath("notificationTime"), processor, NotificationTime.class, getNotificationTime());
		processRosetta(path.newSubPath("collateralValuationAgent"), processor, CollateralValuationAgent.class, getCollateralValuationAgent());
		processor.processBasic(path.newSubPath("cashSettlementDay"), String.class, getCashSettlementDay(), this);
		processor.processBasic(path.newSubPath("securitiesSettlementDay"), String.class, getSecuritiesSettlementDay(), this);
		processRosetta(path.newSubPath("legacyValuationDate"), processor, LegacyValuationDate.class, getLegacyValuationDate());
		processRosetta(path.newSubPath("legacyValuationTime"), processor, LegacyValuationTime.class, getLegacyValuationTime());
		processRosetta(path.newSubPath("legacyValuationAgent"), processor, LegacyValuationAgent.class, getLegacyValuationAgent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationAndTimingBuilder extends CalculationAndTiming, RosettaModelObjectBuilder {
		CalculationAgentTerms.CalculationAgentTermsBuilder getOrCreateCalculationAgentTerms();
		@Override
		CalculationAgentTerms.CalculationAgentTermsBuilder getCalculationAgentTerms();
		BespokeCalculationDate.BespokeCalculationDateBuilder getOrCreateBespokeCalculationDate();
		@Override
		BespokeCalculationDate.BespokeCalculationDateBuilder getBespokeCalculationDate();
		BespokeCalculationTime.BespokeCalculationTimeBuilder getOrCreateBespokeCalculationTime();
		@Override
		BespokeCalculationTime.BespokeCalculationTimeBuilder getBespokeCalculationTime();
		CalculationDateLocation.CalculationDateLocationBuilder getOrCreateCalculationDateLocation();
		@Override
		CalculationDateLocation.CalculationDateLocationBuilder getCalculationDateLocation();
		NotificationTime.NotificationTimeBuilder getOrCreateNotificationTime();
		@Override
		NotificationTime.NotificationTimeBuilder getNotificationTime();
		CollateralValuationAgent.CollateralValuationAgentBuilder getOrCreateCollateralValuationAgent();
		@Override
		CollateralValuationAgent.CollateralValuationAgentBuilder getCollateralValuationAgent();
		LegacyValuationDate.LegacyValuationDateBuilder getOrCreateLegacyValuationDate();
		@Override
		LegacyValuationDate.LegacyValuationDateBuilder getLegacyValuationDate();
		LegacyValuationTime.LegacyValuationTimeBuilder getOrCreateLegacyValuationTime();
		@Override
		LegacyValuationTime.LegacyValuationTimeBuilder getLegacyValuationTime();
		LegacyValuationAgent.LegacyValuationAgentBuilder getOrCreateLegacyValuationAgent();
		@Override
		LegacyValuationAgent.LegacyValuationAgentBuilder getLegacyValuationAgent();
		CalculationAndTiming.CalculationAndTimingBuilder setCalculationAgentTerms(CalculationAgentTerms calculationAgentTerms);
		CalculationAndTiming.CalculationAndTimingBuilder setBespokeCalculationDate(BespokeCalculationDate bespokeCalculationDate);
		CalculationAndTiming.CalculationAndTimingBuilder setBespokeCalculationTime(BespokeCalculationTime bespokeCalculationTime);
		CalculationAndTiming.CalculationAndTimingBuilder setCalculationDateLocation(CalculationDateLocation calculationDateLocation);
		CalculationAndTiming.CalculationAndTimingBuilder setNotificationTime(NotificationTime notificationTime);
		CalculationAndTiming.CalculationAndTimingBuilder setCollateralValuationAgent(CollateralValuationAgent collateralValuationAgent);
		CalculationAndTiming.CalculationAndTimingBuilder setCashSettlementDay(String cashSettlementDay);
		CalculationAndTiming.CalculationAndTimingBuilder setSecuritiesSettlementDay(String securitiesSettlementDay);
		CalculationAndTiming.CalculationAndTimingBuilder setLegacyValuationDate(LegacyValuationDate legacyValuationDate);
		CalculationAndTiming.CalculationAndTimingBuilder setLegacyValuationTime(LegacyValuationTime legacyValuationTime);
		CalculationAndTiming.CalculationAndTimingBuilder setLegacyValuationAgent(LegacyValuationAgent legacyValuationAgent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationAgentTerms"), processor, CalculationAgentTerms.CalculationAgentTermsBuilder.class, getCalculationAgentTerms());
			processRosetta(path.newSubPath("bespokeCalculationDate"), processor, BespokeCalculationDate.BespokeCalculationDateBuilder.class, getBespokeCalculationDate());
			processRosetta(path.newSubPath("bespokeCalculationTime"), processor, BespokeCalculationTime.BespokeCalculationTimeBuilder.class, getBespokeCalculationTime());
			processRosetta(path.newSubPath("calculationDateLocation"), processor, CalculationDateLocation.CalculationDateLocationBuilder.class, getCalculationDateLocation());
			processRosetta(path.newSubPath("notificationTime"), processor, NotificationTime.NotificationTimeBuilder.class, getNotificationTime());
			processRosetta(path.newSubPath("collateralValuationAgent"), processor, CollateralValuationAgent.CollateralValuationAgentBuilder.class, getCollateralValuationAgent());
			processor.processBasic(path.newSubPath("cashSettlementDay"), String.class, getCashSettlementDay(), this);
			processor.processBasic(path.newSubPath("securitiesSettlementDay"), String.class, getSecuritiesSettlementDay(), this);
			processRosetta(path.newSubPath("legacyValuationDate"), processor, LegacyValuationDate.LegacyValuationDateBuilder.class, getLegacyValuationDate());
			processRosetta(path.newSubPath("legacyValuationTime"), processor, LegacyValuationTime.LegacyValuationTimeBuilder.class, getLegacyValuationTime());
			processRosetta(path.newSubPath("legacyValuationAgent"), processor, LegacyValuationAgent.LegacyValuationAgentBuilder.class, getLegacyValuationAgent());
		}
		

		CalculationAndTiming.CalculationAndTimingBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationAndTiming  ***********************/
	class CalculationAndTimingImpl implements CalculationAndTiming {
		private final CalculationAgentTerms calculationAgentTerms;
		private final BespokeCalculationDate bespokeCalculationDate;
		private final BespokeCalculationTime bespokeCalculationTime;
		private final CalculationDateLocation calculationDateLocation;
		private final NotificationTime notificationTime;
		private final CollateralValuationAgent collateralValuationAgent;
		private final String cashSettlementDay;
		private final String securitiesSettlementDay;
		private final LegacyValuationDate legacyValuationDate;
		private final LegacyValuationTime legacyValuationTime;
		private final LegacyValuationAgent legacyValuationAgent;
		
		protected CalculationAndTimingImpl(CalculationAndTiming.CalculationAndTimingBuilder builder) {
			this.calculationAgentTerms = ofNullable(builder.getCalculationAgentTerms()).map(f->f.build()).orElse(null);
			this.bespokeCalculationDate = ofNullable(builder.getBespokeCalculationDate()).map(f->f.build()).orElse(null);
			this.bespokeCalculationTime = ofNullable(builder.getBespokeCalculationTime()).map(f->f.build()).orElse(null);
			this.calculationDateLocation = ofNullable(builder.getCalculationDateLocation()).map(f->f.build()).orElse(null);
			this.notificationTime = ofNullable(builder.getNotificationTime()).map(f->f.build()).orElse(null);
			this.collateralValuationAgent = ofNullable(builder.getCollateralValuationAgent()).map(f->f.build()).orElse(null);
			this.cashSettlementDay = builder.getCashSettlementDay();
			this.securitiesSettlementDay = builder.getSecuritiesSettlementDay();
			this.legacyValuationDate = ofNullable(builder.getLegacyValuationDate()).map(f->f.build()).orElse(null);
			this.legacyValuationTime = ofNullable(builder.getLegacyValuationTime()).map(f->f.build()).orElse(null);
			this.legacyValuationAgent = ofNullable(builder.getLegacyValuationAgent()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationAgentTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentTerms")
		public CalculationAgentTerms getCalculationAgentTerms() {
			return calculationAgentTerms;
		}
		
		@Override
		@RosettaAttribute("bespokeCalculationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCalculationDate")
		public BespokeCalculationDate getBespokeCalculationDate() {
			return bespokeCalculationDate;
		}
		
		@Override
		@RosettaAttribute("bespokeCalculationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCalculationTime")
		public BespokeCalculationTime getBespokeCalculationTime() {
			return bespokeCalculationTime;
		}
		
		@Override
		@RosettaAttribute("calculationDateLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDateLocation")
		public CalculationDateLocation getCalculationDateLocation() {
			return calculationDateLocation;
		}
		
		@Override
		@RosettaAttribute("notificationTime")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notificationTime")
		public NotificationTime getNotificationTime() {
			return notificationTime;
		}
		
		@Override
		@RosettaAttribute("collateralValuationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralValuationAgent")
		public CollateralValuationAgent getCollateralValuationAgent() {
			return collateralValuationAgent;
		}
		
		@Override
		@RosettaAttribute("cashSettlementDay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementDay")
		public String getCashSettlementDay() {
			return cashSettlementDay;
		}
		
		@Override
		@RosettaAttribute("securitiesSettlementDay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("securitiesSettlementDay")
		public String getSecuritiesSettlementDay() {
			return securitiesSettlementDay;
		}
		
		@Override
		@RosettaAttribute("legacyValuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyValuationDate")
		public LegacyValuationDate getLegacyValuationDate() {
			return legacyValuationDate;
		}
		
		@Override
		@RosettaAttribute("legacyValuationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyValuationTime")
		public LegacyValuationTime getLegacyValuationTime() {
			return legacyValuationTime;
		}
		
		@Override
		@RosettaAttribute("legacyValuationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyValuationAgent")
		public LegacyValuationAgent getLegacyValuationAgent() {
			return legacyValuationAgent;
		}
		
		@Override
		public CalculationAndTiming build() {
			return this;
		}
		
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder toBuilder() {
			CalculationAndTiming.CalculationAndTimingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationAndTiming.CalculationAndTimingBuilder builder) {
			ofNullable(getCalculationAgentTerms()).ifPresent(builder::setCalculationAgentTerms);
			ofNullable(getBespokeCalculationDate()).ifPresent(builder::setBespokeCalculationDate);
			ofNullable(getBespokeCalculationTime()).ifPresent(builder::setBespokeCalculationTime);
			ofNullable(getCalculationDateLocation()).ifPresent(builder::setCalculationDateLocation);
			ofNullable(getNotificationTime()).ifPresent(builder::setNotificationTime);
			ofNullable(getCollateralValuationAgent()).ifPresent(builder::setCollateralValuationAgent);
			ofNullable(getCashSettlementDay()).ifPresent(builder::setCashSettlementDay);
			ofNullable(getSecuritiesSettlementDay()).ifPresent(builder::setSecuritiesSettlementDay);
			ofNullable(getLegacyValuationDate()).ifPresent(builder::setLegacyValuationDate);
			ofNullable(getLegacyValuationTime()).ifPresent(builder::setLegacyValuationTime);
			ofNullable(getLegacyValuationAgent()).ifPresent(builder::setLegacyValuationAgent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAndTiming _that = getType().cast(o);
		
			if (!Objects.equals(calculationAgentTerms, _that.getCalculationAgentTerms())) return false;
			if (!Objects.equals(bespokeCalculationDate, _that.getBespokeCalculationDate())) return false;
			if (!Objects.equals(bespokeCalculationTime, _that.getBespokeCalculationTime())) return false;
			if (!Objects.equals(calculationDateLocation, _that.getCalculationDateLocation())) return false;
			if (!Objects.equals(notificationTime, _that.getNotificationTime())) return false;
			if (!Objects.equals(collateralValuationAgent, _that.getCollateralValuationAgent())) return false;
			if (!Objects.equals(cashSettlementDay, _that.getCashSettlementDay())) return false;
			if (!Objects.equals(securitiesSettlementDay, _that.getSecuritiesSettlementDay())) return false;
			if (!Objects.equals(legacyValuationDate, _that.getLegacyValuationDate())) return false;
			if (!Objects.equals(legacyValuationTime, _that.getLegacyValuationTime())) return false;
			if (!Objects.equals(legacyValuationAgent, _that.getLegacyValuationAgent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAgentTerms != null ? calculationAgentTerms.hashCode() : 0);
			_result = 31 * _result + (bespokeCalculationDate != null ? bespokeCalculationDate.hashCode() : 0);
			_result = 31 * _result + (bespokeCalculationTime != null ? bespokeCalculationTime.hashCode() : 0);
			_result = 31 * _result + (calculationDateLocation != null ? calculationDateLocation.hashCode() : 0);
			_result = 31 * _result + (notificationTime != null ? notificationTime.hashCode() : 0);
			_result = 31 * _result + (collateralValuationAgent != null ? collateralValuationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlementDay != null ? cashSettlementDay.hashCode() : 0);
			_result = 31 * _result + (securitiesSettlementDay != null ? securitiesSettlementDay.hashCode() : 0);
			_result = 31 * _result + (legacyValuationDate != null ? legacyValuationDate.hashCode() : 0);
			_result = 31 * _result + (legacyValuationTime != null ? legacyValuationTime.hashCode() : 0);
			_result = 31 * _result + (legacyValuationAgent != null ? legacyValuationAgent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAndTiming {" +
				"calculationAgentTerms=" + this.calculationAgentTerms + ", " +
				"bespokeCalculationDate=" + this.bespokeCalculationDate + ", " +
				"bespokeCalculationTime=" + this.bespokeCalculationTime + ", " +
				"calculationDateLocation=" + this.calculationDateLocation + ", " +
				"notificationTime=" + this.notificationTime + ", " +
				"collateralValuationAgent=" + this.collateralValuationAgent + ", " +
				"cashSettlementDay=" + this.cashSettlementDay + ", " +
				"securitiesSettlementDay=" + this.securitiesSettlementDay + ", " +
				"legacyValuationDate=" + this.legacyValuationDate + ", " +
				"legacyValuationTime=" + this.legacyValuationTime + ", " +
				"legacyValuationAgent=" + this.legacyValuationAgent +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationAndTiming  ***********************/
	class CalculationAndTimingBuilderImpl implements CalculationAndTiming.CalculationAndTimingBuilder {
	
		protected CalculationAgentTerms.CalculationAgentTermsBuilder calculationAgentTerms;
		protected BespokeCalculationDate.BespokeCalculationDateBuilder bespokeCalculationDate;
		protected BespokeCalculationTime.BespokeCalculationTimeBuilder bespokeCalculationTime;
		protected CalculationDateLocation.CalculationDateLocationBuilder calculationDateLocation;
		protected NotificationTime.NotificationTimeBuilder notificationTime;
		protected CollateralValuationAgent.CollateralValuationAgentBuilder collateralValuationAgent;
		protected String cashSettlementDay;
		protected String securitiesSettlementDay;
		protected LegacyValuationDate.LegacyValuationDateBuilder legacyValuationDate;
		protected LegacyValuationTime.LegacyValuationTimeBuilder legacyValuationTime;
		protected LegacyValuationAgent.LegacyValuationAgentBuilder legacyValuationAgent;
		
		@Override
		@RosettaAttribute("calculationAgentTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentTerms")
		public CalculationAgentTerms.CalculationAgentTermsBuilder getCalculationAgentTerms() {
			return calculationAgentTerms;
		}
		
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder getOrCreateCalculationAgentTerms() {
			CalculationAgentTerms.CalculationAgentTermsBuilder result;
			if (calculationAgentTerms!=null) {
				result = calculationAgentTerms;
			}
			else {
				result = calculationAgentTerms = CalculationAgentTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bespokeCalculationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCalculationDate")
		public BespokeCalculationDate.BespokeCalculationDateBuilder getBespokeCalculationDate() {
			return bespokeCalculationDate;
		}
		
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder getOrCreateBespokeCalculationDate() {
			BespokeCalculationDate.BespokeCalculationDateBuilder result;
			if (bespokeCalculationDate!=null) {
				result = bespokeCalculationDate;
			}
			else {
				result = bespokeCalculationDate = BespokeCalculationDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("bespokeCalculationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCalculationTime")
		public BespokeCalculationTime.BespokeCalculationTimeBuilder getBespokeCalculationTime() {
			return bespokeCalculationTime;
		}
		
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder getOrCreateBespokeCalculationTime() {
			BespokeCalculationTime.BespokeCalculationTimeBuilder result;
			if (bespokeCalculationTime!=null) {
				result = bespokeCalculationTime;
			}
			else {
				result = bespokeCalculationTime = BespokeCalculationTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationDateLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDateLocation")
		public CalculationDateLocation.CalculationDateLocationBuilder getCalculationDateLocation() {
			return calculationDateLocation;
		}
		
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder getOrCreateCalculationDateLocation() {
			CalculationDateLocation.CalculationDateLocationBuilder result;
			if (calculationDateLocation!=null) {
				result = calculationDateLocation;
			}
			else {
				result = calculationDateLocation = CalculationDateLocation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notificationTime")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notificationTime")
		public NotificationTime.NotificationTimeBuilder getNotificationTime() {
			return notificationTime;
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder getOrCreateNotificationTime() {
			NotificationTime.NotificationTimeBuilder result;
			if (notificationTime!=null) {
				result = notificationTime;
			}
			else {
				result = notificationTime = NotificationTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralValuationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralValuationAgent")
		public CollateralValuationAgent.CollateralValuationAgentBuilder getCollateralValuationAgent() {
			return collateralValuationAgent;
		}
		
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder getOrCreateCollateralValuationAgent() {
			CollateralValuationAgent.CollateralValuationAgentBuilder result;
			if (collateralValuationAgent!=null) {
				result = collateralValuationAgent;
			}
			else {
				result = collateralValuationAgent = CollateralValuationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlementDay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementDay")
		public String getCashSettlementDay() {
			return cashSettlementDay;
		}
		
		@Override
		@RosettaAttribute("securitiesSettlementDay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("securitiesSettlementDay")
		public String getSecuritiesSettlementDay() {
			return securitiesSettlementDay;
		}
		
		@Override
		@RosettaAttribute("legacyValuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyValuationDate")
		public LegacyValuationDate.LegacyValuationDateBuilder getLegacyValuationDate() {
			return legacyValuationDate;
		}
		
		@Override
		public LegacyValuationDate.LegacyValuationDateBuilder getOrCreateLegacyValuationDate() {
			LegacyValuationDate.LegacyValuationDateBuilder result;
			if (legacyValuationDate!=null) {
				result = legacyValuationDate;
			}
			else {
				result = legacyValuationDate = LegacyValuationDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyValuationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyValuationTime")
		public LegacyValuationTime.LegacyValuationTimeBuilder getLegacyValuationTime() {
			return legacyValuationTime;
		}
		
		@Override
		public LegacyValuationTime.LegacyValuationTimeBuilder getOrCreateLegacyValuationTime() {
			LegacyValuationTime.LegacyValuationTimeBuilder result;
			if (legacyValuationTime!=null) {
				result = legacyValuationTime;
			}
			else {
				result = legacyValuationTime = LegacyValuationTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyValuationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyValuationAgent")
		public LegacyValuationAgent.LegacyValuationAgentBuilder getLegacyValuationAgent() {
			return legacyValuationAgent;
		}
		
		@Override
		public LegacyValuationAgent.LegacyValuationAgentBuilder getOrCreateLegacyValuationAgent() {
			LegacyValuationAgent.LegacyValuationAgentBuilder result;
			if (legacyValuationAgent!=null) {
				result = legacyValuationAgent;
			}
			else {
				result = legacyValuationAgent = LegacyValuationAgent.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("calculationAgentTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAgentTerms")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setCalculationAgentTerms(CalculationAgentTerms _calculationAgentTerms) {
			this.calculationAgentTerms = _calculationAgentTerms == null ? null : _calculationAgentTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("bespokeCalculationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bespokeCalculationDate")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setBespokeCalculationDate(BespokeCalculationDate _bespokeCalculationDate) {
			this.bespokeCalculationDate = _bespokeCalculationDate == null ? null : _bespokeCalculationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("bespokeCalculationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bespokeCalculationTime")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setBespokeCalculationTime(BespokeCalculationTime _bespokeCalculationTime) {
			this.bespokeCalculationTime = _bespokeCalculationTime == null ? null : _bespokeCalculationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationDateLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDateLocation")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setCalculationDateLocation(CalculationDateLocation _calculationDateLocation) {
			this.calculationDateLocation = _calculationDateLocation == null ? null : _calculationDateLocation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notificationTime")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notificationTime")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setNotificationTime(NotificationTime _notificationTime) {
			this.notificationTime = _notificationTime == null ? null : _notificationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralValuationAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralValuationAgent")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setCollateralValuationAgent(CollateralValuationAgent _collateralValuationAgent) {
			this.collateralValuationAgent = _collateralValuationAgent == null ? null : _collateralValuationAgent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlementDay")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementDay")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setCashSettlementDay(String _cashSettlementDay) {
			this.cashSettlementDay = _cashSettlementDay == null ? null : _cashSettlementDay;
			return this;
		}
		
		@RosettaAttribute("securitiesSettlementDay")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("securitiesSettlementDay")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setSecuritiesSettlementDay(String _securitiesSettlementDay) {
			this.securitiesSettlementDay = _securitiesSettlementDay == null ? null : _securitiesSettlementDay;
			return this;
		}
		
		@RosettaAttribute("legacyValuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyValuationDate")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setLegacyValuationDate(LegacyValuationDate _legacyValuationDate) {
			this.legacyValuationDate = _legacyValuationDate == null ? null : _legacyValuationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyValuationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyValuationTime")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setLegacyValuationTime(LegacyValuationTime _legacyValuationTime) {
			this.legacyValuationTime = _legacyValuationTime == null ? null : _legacyValuationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyValuationAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyValuationAgent")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder setLegacyValuationAgent(LegacyValuationAgent _legacyValuationAgent) {
			this.legacyValuationAgent = _legacyValuationAgent == null ? null : _legacyValuationAgent.toBuilder();
			return this;
		}
		
		@Override
		public CalculationAndTiming build() {
			return new CalculationAndTiming.CalculationAndTimingImpl(this);
		}
		
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder prune() {
			if (calculationAgentTerms!=null && !calculationAgentTerms.prune().hasData()) calculationAgentTerms = null;
			if (bespokeCalculationDate!=null && !bespokeCalculationDate.prune().hasData()) bespokeCalculationDate = null;
			if (bespokeCalculationTime!=null && !bespokeCalculationTime.prune().hasData()) bespokeCalculationTime = null;
			if (calculationDateLocation!=null && !calculationDateLocation.prune().hasData()) calculationDateLocation = null;
			if (notificationTime!=null && !notificationTime.prune().hasData()) notificationTime = null;
			if (collateralValuationAgent!=null && !collateralValuationAgent.prune().hasData()) collateralValuationAgent = null;
			if (legacyValuationDate!=null && !legacyValuationDate.prune().hasData()) legacyValuationDate = null;
			if (legacyValuationTime!=null && !legacyValuationTime.prune().hasData()) legacyValuationTime = null;
			if (legacyValuationAgent!=null && !legacyValuationAgent.prune().hasData()) legacyValuationAgent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationAgentTerms()!=null && getCalculationAgentTerms().hasData()) return true;
			if (getBespokeCalculationDate()!=null && getBespokeCalculationDate().hasData()) return true;
			if (getBespokeCalculationTime()!=null && getBespokeCalculationTime().hasData()) return true;
			if (getCalculationDateLocation()!=null && getCalculationDateLocation().hasData()) return true;
			if (getNotificationTime()!=null && getNotificationTime().hasData()) return true;
			if (getCollateralValuationAgent()!=null && getCollateralValuationAgent().hasData()) return true;
			if (getCashSettlementDay()!=null) return true;
			if (getSecuritiesSettlementDay()!=null) return true;
			if (getLegacyValuationDate()!=null && getLegacyValuationDate().hasData()) return true;
			if (getLegacyValuationTime()!=null && getLegacyValuationTime().hasData()) return true;
			if (getLegacyValuationAgent()!=null && getLegacyValuationAgent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationAndTiming.CalculationAndTimingBuilder o = (CalculationAndTiming.CalculationAndTimingBuilder) other;
			
			merger.mergeRosetta(getCalculationAgentTerms(), o.getCalculationAgentTerms(), this::setCalculationAgentTerms);
			merger.mergeRosetta(getBespokeCalculationDate(), o.getBespokeCalculationDate(), this::setBespokeCalculationDate);
			merger.mergeRosetta(getBespokeCalculationTime(), o.getBespokeCalculationTime(), this::setBespokeCalculationTime);
			merger.mergeRosetta(getCalculationDateLocation(), o.getCalculationDateLocation(), this::setCalculationDateLocation);
			merger.mergeRosetta(getNotificationTime(), o.getNotificationTime(), this::setNotificationTime);
			merger.mergeRosetta(getCollateralValuationAgent(), o.getCollateralValuationAgent(), this::setCollateralValuationAgent);
			merger.mergeRosetta(getLegacyValuationDate(), o.getLegacyValuationDate(), this::setLegacyValuationDate);
			merger.mergeRosetta(getLegacyValuationTime(), o.getLegacyValuationTime(), this::setLegacyValuationTime);
			merger.mergeRosetta(getLegacyValuationAgent(), o.getLegacyValuationAgent(), this::setLegacyValuationAgent);
			
			merger.mergeBasic(getCashSettlementDay(), o.getCashSettlementDay(), this::setCashSettlementDay);
			merger.mergeBasic(getSecuritiesSettlementDay(), o.getSecuritiesSettlementDay(), this::setSecuritiesSettlementDay);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAndTiming _that = getType().cast(o);
		
			if (!Objects.equals(calculationAgentTerms, _that.getCalculationAgentTerms())) return false;
			if (!Objects.equals(bespokeCalculationDate, _that.getBespokeCalculationDate())) return false;
			if (!Objects.equals(bespokeCalculationTime, _that.getBespokeCalculationTime())) return false;
			if (!Objects.equals(calculationDateLocation, _that.getCalculationDateLocation())) return false;
			if (!Objects.equals(notificationTime, _that.getNotificationTime())) return false;
			if (!Objects.equals(collateralValuationAgent, _that.getCollateralValuationAgent())) return false;
			if (!Objects.equals(cashSettlementDay, _that.getCashSettlementDay())) return false;
			if (!Objects.equals(securitiesSettlementDay, _that.getSecuritiesSettlementDay())) return false;
			if (!Objects.equals(legacyValuationDate, _that.getLegacyValuationDate())) return false;
			if (!Objects.equals(legacyValuationTime, _that.getLegacyValuationTime())) return false;
			if (!Objects.equals(legacyValuationAgent, _that.getLegacyValuationAgent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAgentTerms != null ? calculationAgentTerms.hashCode() : 0);
			_result = 31 * _result + (bespokeCalculationDate != null ? bespokeCalculationDate.hashCode() : 0);
			_result = 31 * _result + (bespokeCalculationTime != null ? bespokeCalculationTime.hashCode() : 0);
			_result = 31 * _result + (calculationDateLocation != null ? calculationDateLocation.hashCode() : 0);
			_result = 31 * _result + (notificationTime != null ? notificationTime.hashCode() : 0);
			_result = 31 * _result + (collateralValuationAgent != null ? collateralValuationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlementDay != null ? cashSettlementDay.hashCode() : 0);
			_result = 31 * _result + (securitiesSettlementDay != null ? securitiesSettlementDay.hashCode() : 0);
			_result = 31 * _result + (legacyValuationDate != null ? legacyValuationDate.hashCode() : 0);
			_result = 31 * _result + (legacyValuationTime != null ? legacyValuationTime.hashCode() : 0);
			_result = 31 * _result + (legacyValuationAgent != null ? legacyValuationAgent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAndTimingBuilder {" +
				"calculationAgentTerms=" + this.calculationAgentTerms + ", " +
				"bespokeCalculationDate=" + this.bespokeCalculationDate + ", " +
				"bespokeCalculationTime=" + this.bespokeCalculationTime + ", " +
				"calculationDateLocation=" + this.calculationDateLocation + ", " +
				"notificationTime=" + this.notificationTime + ", " +
				"collateralValuationAgent=" + this.collateralValuationAgent + ", " +
				"cashSettlementDay=" + this.cashSettlementDay + ", " +
				"securitiesSettlementDay=" + this.securitiesSettlementDay + ", " +
				"legacyValuationDate=" + this.legacyValuationDate + ", " +
				"legacyValuationTime=" + this.legacyValuationTime + ", " +
				"legacyValuationAgent=" + this.legacyValuationAgent +
			'}';
		}
	}
}
