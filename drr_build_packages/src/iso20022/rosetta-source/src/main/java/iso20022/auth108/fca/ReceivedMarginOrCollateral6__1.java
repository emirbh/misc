package iso20022.auth108.fca;

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
import iso20022.auth108.fca.meta.ReceivedMarginOrCollateral6__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information on the received margin or collateral of the transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="ReceivedMarginOrCollateral6__1", builder=ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ReceivedMarginOrCollateral6__1", model="iso20022", builder=ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1BuilderImpl.class, version="${project.version}")
public interface ReceivedMarginOrCollateral6__1 extends RosettaModelObject {

	ReceivedMarginOrCollateral6__1Meta metaData = new ReceivedMarginOrCollateral6__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Value of the initial margin received by the reporting counterparty from the other counterparty. Where initial margin is received on a portfolio basis, this field should include the overall value of initial margin received for the portfolio.
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnRcvdPreHrcut();
	/**
	 * Value of the initial margin received by the reporting counterparty from the other counterparty. Where initial margin is received on a portfolio basis, this field should include the overall value of initial margin received for the portfolio. Post-haircut values of margins depend on associated risk of changes in collateral value and therefore on the nature of the collateral posted (or collected).
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnRcvdPstHrcut();
	/**
	 * Value of the variation margin received, including cash settled, by the reporting counterparty from the other counterparty.  Where variation margin is received on a portfolio basis, this field should include the overall value of variation margin received for the portfolio.
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getVartnMrgnRcvdPreHrcut();
	/**
	 * Value of the variation margin received, including cash settled, by the reporting counterparty from the other counterparty.  Where variation margin is received on a portfolio basis, this field should include the overall value of variation margin received for the portfolio. Post-haircut values of margins depend on associated risk of changes in collateral value and therefore on the nature of the collateral posted (or collected).
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getVartnMrgnRcvdPstHrcut();
	/**
	 * Value of collateral received in excess of the required collateral.
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getXcssCollRcvd();

	/*********************** Build Methods  ***********************/
	ReceivedMarginOrCollateral6__1 build();
	
	ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder toBuilder();
	
	static ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder builder() {
		return new ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReceivedMarginOrCollateral6__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReceivedMarginOrCollateral6__1> getType() {
		return ReceivedMarginOrCollateral6__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initlMrgnRcvdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getInitlMrgnRcvdPreHrcut());
		processRosetta(path.newSubPath("initlMrgnRcvdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getInitlMrgnRcvdPstHrcut());
		processRosetta(path.newSubPath("vartnMrgnRcvdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getVartnMrgnRcvdPreHrcut());
		processRosetta(path.newSubPath("vartnMrgnRcvdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getVartnMrgnRcvdPstHrcut());
		processRosetta(path.newSubPath("xcssCollRcvd"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getXcssCollRcvd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReceivedMarginOrCollateral6__1Builder extends ReceivedMarginOrCollateral6__1, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnRcvdPreHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnRcvdPreHrcut();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnRcvdPstHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnRcvdPstHrcut();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateVartnMrgnRcvdPreHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getVartnMrgnRcvdPreHrcut();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateVartnMrgnRcvdPstHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getVartnMrgnRcvdPstHrcut();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateXcssCollRcvd();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getXcssCollRcvd();
		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder setInitlMrgnRcvdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnRcvdPreHrcut);
		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder setInitlMrgnRcvdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnRcvdPstHrcut);
		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder setVartnMrgnRcvdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount vartnMrgnRcvdPreHrcut);
		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder setVartnMrgnRcvdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount vartnMrgnRcvdPstHrcut);
		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder setXcssCollRcvd(ActiveOrHistoricCurrencyAnd5DecimalAmount xcssCollRcvd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initlMrgnRcvdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getInitlMrgnRcvdPreHrcut());
			processRosetta(path.newSubPath("initlMrgnRcvdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getInitlMrgnRcvdPstHrcut());
			processRosetta(path.newSubPath("vartnMrgnRcvdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getVartnMrgnRcvdPreHrcut());
			processRosetta(path.newSubPath("vartnMrgnRcvdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getVartnMrgnRcvdPstHrcut());
			processRosetta(path.newSubPath("xcssCollRcvd"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getXcssCollRcvd());
		}
		

		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder prune();
	}

	/*********************** Immutable Implementation of ReceivedMarginOrCollateral6__1  ***********************/
	class ReceivedMarginOrCollateral6__1Impl implements ReceivedMarginOrCollateral6__1 {
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnRcvdPreHrcut;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnRcvdPstHrcut;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount vartnMrgnRcvdPreHrcut;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount vartnMrgnRcvdPstHrcut;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount xcssCollRcvd;
		
		protected ReceivedMarginOrCollateral6__1Impl(ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder builder) {
			this.initlMrgnRcvdPreHrcut = ofNullable(builder.getInitlMrgnRcvdPreHrcut()).map(f->f.build()).orElse(null);
			this.initlMrgnRcvdPstHrcut = ofNullable(builder.getInitlMrgnRcvdPstHrcut()).map(f->f.build()).orElse(null);
			this.vartnMrgnRcvdPreHrcut = ofNullable(builder.getVartnMrgnRcvdPreHrcut()).map(f->f.build()).orElse(null);
			this.vartnMrgnRcvdPstHrcut = ofNullable(builder.getVartnMrgnRcvdPstHrcut()).map(f->f.build()).orElse(null);
			this.xcssCollRcvd = ofNullable(builder.getXcssCollRcvd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initlMrgnRcvdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnRcvdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnRcvdPreHrcut() {
			return initlMrgnRcvdPreHrcut;
		}
		
		@Override
		@RosettaAttribute("initlMrgnRcvdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnRcvdPstHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnRcvdPstHrcut() {
			return initlMrgnRcvdPstHrcut;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnRcvdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnRcvdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getVartnMrgnRcvdPreHrcut() {
			return vartnMrgnRcvdPreHrcut;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnRcvdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnRcvdPstHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getVartnMrgnRcvdPstHrcut() {
			return vartnMrgnRcvdPstHrcut;
		}
		
		@Override
		@RosettaAttribute("xcssCollRcvd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xcssCollRcvd")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getXcssCollRcvd() {
			return xcssCollRcvd;
		}
		
		@Override
		public ReceivedMarginOrCollateral6__1 build() {
			return this;
		}
		
		@Override
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder toBuilder() {
			ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder builder) {
			ofNullable(getInitlMrgnRcvdPreHrcut()).ifPresent(builder::setInitlMrgnRcvdPreHrcut);
			ofNullable(getInitlMrgnRcvdPstHrcut()).ifPresent(builder::setInitlMrgnRcvdPstHrcut);
			ofNullable(getVartnMrgnRcvdPreHrcut()).ifPresent(builder::setVartnMrgnRcvdPreHrcut);
			ofNullable(getVartnMrgnRcvdPstHrcut()).ifPresent(builder::setVartnMrgnRcvdPstHrcut);
			ofNullable(getXcssCollRcvd()).ifPresent(builder::setXcssCollRcvd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReceivedMarginOrCollateral6__1 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnRcvdPreHrcut, _that.getInitlMrgnRcvdPreHrcut())) return false;
			if (!Objects.equals(initlMrgnRcvdPstHrcut, _that.getInitlMrgnRcvdPstHrcut())) return false;
			if (!Objects.equals(vartnMrgnRcvdPreHrcut, _that.getVartnMrgnRcvdPreHrcut())) return false;
			if (!Objects.equals(vartnMrgnRcvdPstHrcut, _that.getVartnMrgnRcvdPstHrcut())) return false;
			if (!Objects.equals(xcssCollRcvd, _that.getXcssCollRcvd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnRcvdPreHrcut != null ? initlMrgnRcvdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (initlMrgnRcvdPstHrcut != null ? initlMrgnRcvdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnRcvdPreHrcut != null ? vartnMrgnRcvdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnRcvdPstHrcut != null ? vartnMrgnRcvdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (xcssCollRcvd != null ? xcssCollRcvd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReceivedMarginOrCollateral6__1 {" +
				"initlMrgnRcvdPreHrcut=" + this.initlMrgnRcvdPreHrcut + ", " +
				"initlMrgnRcvdPstHrcut=" + this.initlMrgnRcvdPstHrcut + ", " +
				"vartnMrgnRcvdPreHrcut=" + this.vartnMrgnRcvdPreHrcut + ", " +
				"vartnMrgnRcvdPstHrcut=" + this.vartnMrgnRcvdPstHrcut + ", " +
				"xcssCollRcvd=" + this.xcssCollRcvd +
			'}';
		}
	}

	/*********************** Builder Implementation of ReceivedMarginOrCollateral6__1  ***********************/
	class ReceivedMarginOrCollateral6__1BuilderImpl implements ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder {
	
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder initlMrgnRcvdPreHrcut;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder initlMrgnRcvdPstHrcut;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder vartnMrgnRcvdPreHrcut;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder vartnMrgnRcvdPstHrcut;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder xcssCollRcvd;
		
		@Override
		@RosettaAttribute("initlMrgnRcvdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnRcvdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnRcvdPreHrcut() {
			return initlMrgnRcvdPreHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnRcvdPreHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (initlMrgnRcvdPreHrcut!=null) {
				result = initlMrgnRcvdPreHrcut;
			}
			else {
				result = initlMrgnRcvdPreHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initlMrgnRcvdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnRcvdPstHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnRcvdPstHrcut() {
			return initlMrgnRcvdPstHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnRcvdPstHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (initlMrgnRcvdPstHrcut!=null) {
				result = initlMrgnRcvdPstHrcut;
			}
			else {
				result = initlMrgnRcvdPstHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnRcvdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnRcvdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getVartnMrgnRcvdPreHrcut() {
			return vartnMrgnRcvdPreHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateVartnMrgnRcvdPreHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (vartnMrgnRcvdPreHrcut!=null) {
				result = vartnMrgnRcvdPreHrcut;
			}
			else {
				result = vartnMrgnRcvdPreHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnRcvdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnRcvdPstHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getVartnMrgnRcvdPstHrcut() {
			return vartnMrgnRcvdPstHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateVartnMrgnRcvdPstHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (vartnMrgnRcvdPstHrcut!=null) {
				result = vartnMrgnRcvdPstHrcut;
			}
			else {
				result = vartnMrgnRcvdPstHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("xcssCollRcvd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xcssCollRcvd")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getXcssCollRcvd() {
			return xcssCollRcvd;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateXcssCollRcvd() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (xcssCollRcvd!=null) {
				result = xcssCollRcvd;
			}
			else {
				result = xcssCollRcvd = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("initlMrgnRcvdPreHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnRcvdPreHrcut")
		@Override
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder setInitlMrgnRcvdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _initlMrgnRcvdPreHrcut) {
			this.initlMrgnRcvdPreHrcut = _initlMrgnRcvdPreHrcut == null ? null : _initlMrgnRcvdPreHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initlMrgnRcvdPstHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnRcvdPstHrcut")
		@Override
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder setInitlMrgnRcvdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _initlMrgnRcvdPstHrcut) {
			this.initlMrgnRcvdPstHrcut = _initlMrgnRcvdPstHrcut == null ? null : _initlMrgnRcvdPstHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnRcvdPreHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnRcvdPreHrcut")
		@Override
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder setVartnMrgnRcvdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _vartnMrgnRcvdPreHrcut) {
			this.vartnMrgnRcvdPreHrcut = _vartnMrgnRcvdPreHrcut == null ? null : _vartnMrgnRcvdPreHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnRcvdPstHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnRcvdPstHrcut")
		@Override
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder setVartnMrgnRcvdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _vartnMrgnRcvdPstHrcut) {
			this.vartnMrgnRcvdPstHrcut = _vartnMrgnRcvdPstHrcut == null ? null : _vartnMrgnRcvdPstHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("xcssCollRcvd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("xcssCollRcvd")
		@Override
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder setXcssCollRcvd(ActiveOrHistoricCurrencyAnd5DecimalAmount _xcssCollRcvd) {
			this.xcssCollRcvd = _xcssCollRcvd == null ? null : _xcssCollRcvd.toBuilder();
			return this;
		}
		
		@Override
		public ReceivedMarginOrCollateral6__1 build() {
			return new ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Impl(this);
		}
		
		@Override
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder prune() {
			if (initlMrgnRcvdPreHrcut!=null && !initlMrgnRcvdPreHrcut.prune().hasData()) initlMrgnRcvdPreHrcut = null;
			if (initlMrgnRcvdPstHrcut!=null && !initlMrgnRcvdPstHrcut.prune().hasData()) initlMrgnRcvdPstHrcut = null;
			if (vartnMrgnRcvdPreHrcut!=null && !vartnMrgnRcvdPreHrcut.prune().hasData()) vartnMrgnRcvdPreHrcut = null;
			if (vartnMrgnRcvdPstHrcut!=null && !vartnMrgnRcvdPstHrcut.prune().hasData()) vartnMrgnRcvdPstHrcut = null;
			if (xcssCollRcvd!=null && !xcssCollRcvd.prune().hasData()) xcssCollRcvd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitlMrgnRcvdPreHrcut()!=null && getInitlMrgnRcvdPreHrcut().hasData()) return true;
			if (getInitlMrgnRcvdPstHrcut()!=null && getInitlMrgnRcvdPstHrcut().hasData()) return true;
			if (getVartnMrgnRcvdPreHrcut()!=null && getVartnMrgnRcvdPreHrcut().hasData()) return true;
			if (getVartnMrgnRcvdPstHrcut()!=null && getVartnMrgnRcvdPstHrcut().hasData()) return true;
			if (getXcssCollRcvd()!=null && getXcssCollRcvd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder o = (ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder) other;
			
			merger.mergeRosetta(getInitlMrgnRcvdPreHrcut(), o.getInitlMrgnRcvdPreHrcut(), this::setInitlMrgnRcvdPreHrcut);
			merger.mergeRosetta(getInitlMrgnRcvdPstHrcut(), o.getInitlMrgnRcvdPstHrcut(), this::setInitlMrgnRcvdPstHrcut);
			merger.mergeRosetta(getVartnMrgnRcvdPreHrcut(), o.getVartnMrgnRcvdPreHrcut(), this::setVartnMrgnRcvdPreHrcut);
			merger.mergeRosetta(getVartnMrgnRcvdPstHrcut(), o.getVartnMrgnRcvdPstHrcut(), this::setVartnMrgnRcvdPstHrcut);
			merger.mergeRosetta(getXcssCollRcvd(), o.getXcssCollRcvd(), this::setXcssCollRcvd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReceivedMarginOrCollateral6__1 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnRcvdPreHrcut, _that.getInitlMrgnRcvdPreHrcut())) return false;
			if (!Objects.equals(initlMrgnRcvdPstHrcut, _that.getInitlMrgnRcvdPstHrcut())) return false;
			if (!Objects.equals(vartnMrgnRcvdPreHrcut, _that.getVartnMrgnRcvdPreHrcut())) return false;
			if (!Objects.equals(vartnMrgnRcvdPstHrcut, _that.getVartnMrgnRcvdPstHrcut())) return false;
			if (!Objects.equals(xcssCollRcvd, _that.getXcssCollRcvd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnRcvdPreHrcut != null ? initlMrgnRcvdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (initlMrgnRcvdPstHrcut != null ? initlMrgnRcvdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnRcvdPreHrcut != null ? vartnMrgnRcvdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnRcvdPstHrcut != null ? vartnMrgnRcvdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (xcssCollRcvd != null ? xcssCollRcvd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReceivedMarginOrCollateral6__1Builder {" +
				"initlMrgnRcvdPreHrcut=" + this.initlMrgnRcvdPreHrcut + ", " +
				"initlMrgnRcvdPstHrcut=" + this.initlMrgnRcvdPstHrcut + ", " +
				"vartnMrgnRcvdPreHrcut=" + this.vartnMrgnRcvdPreHrcut + ", " +
				"vartnMrgnRcvdPstHrcut=" + this.vartnMrgnRcvdPstHrcut + ", " +
				"xcssCollRcvd=" + this.xcssCollRcvd +
			'}';
		}
	}
}
