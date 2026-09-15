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
import iso20022.auth108.iso.meta.ReceivedMarginOrCollateral6Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information on the received margin or collateral of the transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="ReceivedMarginOrCollateral6", builder=ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ReceivedMarginOrCollateral6", model="iso20022", builder=ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6BuilderImpl.class, version="${project.version}")
public interface ReceivedMarginOrCollateral6 extends RosettaModelObject {

	ReceivedMarginOrCollateral6Meta metaData = new ReceivedMarginOrCollateral6Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Value of the initial margin received by the reporting counterparty from the other counterparty.  Where initial margin is received on a portfolio basis, this field should include the overall value of initial margin received for the portfolio.
	 */
	ActiveOrHistoricCurrencyAnd20DecimalAmount getInitlMrgnRcvdPreHrcut();
	/**
	 * Value of the initial margin received by the reporting counterparty from the other counterparty.  Where initial margin is received on a portfolio basis, this field should include the overall value of initial margin received for the portfolio.  Post-haircut values of margins depend on associated risk of changes in collateral value and therefore on the nature of the collateral posted (or collected).
	 */
	ActiveOrHistoricCurrencyAnd20DecimalAmount getInitlMrgnRcvdPstHrcut();
	/**
	 * Value of the variation margin received, including cash settled, by the reporting counterparty from the other counterparty.   Where variation margin is received on a portfolio basis, this field should include the overall value of variation margin received for the portfolio.
	 */
	ActiveOrHistoricCurrencyAnd20DecimalAmount getVartnMrgnRcvdPreHrcut();
	/**
	 * Value of the variation margin received, including cash settled, by the reporting counterparty from the other counterparty.   Where variation margin is received on a portfolio basis, this field should include the overall value of variation margin received for the portfolio.  Post-haircut values of margins depend on associated risk of changes in collateral value and therefore on the nature of the collateral posted (or collected).
	 */
	ActiveOrHistoricCurrencyAnd20DecimalAmount getVartnMrgnRcvdPstHrcut();
	/**
	 * Value of collateral received in excess of the required collateral.
	 */
	ActiveOrHistoricCurrencyAnd20DecimalAmount getXcssCollRcvd();

	/*********************** Build Methods  ***********************/
	ReceivedMarginOrCollateral6 build();
	
	ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder toBuilder();
	
	static ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder builder() {
		return new ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReceivedMarginOrCollateral6> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReceivedMarginOrCollateral6> getType() {
		return ReceivedMarginOrCollateral6.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initlMrgnRcvdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.class, getInitlMrgnRcvdPreHrcut());
		processRosetta(path.newSubPath("initlMrgnRcvdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.class, getInitlMrgnRcvdPstHrcut());
		processRosetta(path.newSubPath("vartnMrgnRcvdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.class, getVartnMrgnRcvdPreHrcut());
		processRosetta(path.newSubPath("vartnMrgnRcvdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.class, getVartnMrgnRcvdPstHrcut());
		processRosetta(path.newSubPath("xcssCollRcvd"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.class, getXcssCollRcvd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReceivedMarginOrCollateral6Builder extends ReceivedMarginOrCollateral6, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateInitlMrgnRcvdPreHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getInitlMrgnRcvdPreHrcut();
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateInitlMrgnRcvdPstHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getInitlMrgnRcvdPstHrcut();
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateVartnMrgnRcvdPreHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getVartnMrgnRcvdPreHrcut();
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateVartnMrgnRcvdPstHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getVartnMrgnRcvdPstHrcut();
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateXcssCollRcvd();
		@Override
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getXcssCollRcvd();
		ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder setInitlMrgnRcvdPreHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount initlMrgnRcvdPreHrcut);
		ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder setInitlMrgnRcvdPstHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount initlMrgnRcvdPstHrcut);
		ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder setVartnMrgnRcvdPreHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount vartnMrgnRcvdPreHrcut);
		ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder setVartnMrgnRcvdPstHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount vartnMrgnRcvdPstHrcut);
		ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder setXcssCollRcvd(ActiveOrHistoricCurrencyAnd20DecimalAmount xcssCollRcvd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initlMrgnRcvdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder.class, getInitlMrgnRcvdPreHrcut());
			processRosetta(path.newSubPath("initlMrgnRcvdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder.class, getInitlMrgnRcvdPstHrcut());
			processRosetta(path.newSubPath("vartnMrgnRcvdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder.class, getVartnMrgnRcvdPreHrcut());
			processRosetta(path.newSubPath("vartnMrgnRcvdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder.class, getVartnMrgnRcvdPstHrcut());
			processRosetta(path.newSubPath("xcssCollRcvd"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder.class, getXcssCollRcvd());
		}
		

		ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder prune();
	}

	/*********************** Immutable Implementation of ReceivedMarginOrCollateral6  ***********************/
	class ReceivedMarginOrCollateral6Impl implements ReceivedMarginOrCollateral6 {
		private final ActiveOrHistoricCurrencyAnd20DecimalAmount initlMrgnRcvdPreHrcut;
		private final ActiveOrHistoricCurrencyAnd20DecimalAmount initlMrgnRcvdPstHrcut;
		private final ActiveOrHistoricCurrencyAnd20DecimalAmount vartnMrgnRcvdPreHrcut;
		private final ActiveOrHistoricCurrencyAnd20DecimalAmount vartnMrgnRcvdPstHrcut;
		private final ActiveOrHistoricCurrencyAnd20DecimalAmount xcssCollRcvd;
		
		protected ReceivedMarginOrCollateral6Impl(ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder builder) {
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
		public ActiveOrHistoricCurrencyAnd20DecimalAmount getInitlMrgnRcvdPreHrcut() {
			return initlMrgnRcvdPreHrcut;
		}
		
		@Override
		@RosettaAttribute("initlMrgnRcvdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnRcvdPstHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount getInitlMrgnRcvdPstHrcut() {
			return initlMrgnRcvdPstHrcut;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnRcvdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnRcvdPreHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount getVartnMrgnRcvdPreHrcut() {
			return vartnMrgnRcvdPreHrcut;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnRcvdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnRcvdPstHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount getVartnMrgnRcvdPstHrcut() {
			return vartnMrgnRcvdPstHrcut;
		}
		
		@Override
		@RosettaAttribute("xcssCollRcvd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xcssCollRcvd")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount getXcssCollRcvd() {
			return xcssCollRcvd;
		}
		
		@Override
		public ReceivedMarginOrCollateral6 build() {
			return this;
		}
		
		@Override
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder toBuilder() {
			ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder builder) {
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
		
			ReceivedMarginOrCollateral6 _that = getType().cast(o);
		
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
			return "ReceivedMarginOrCollateral6 {" +
				"initlMrgnRcvdPreHrcut=" + this.initlMrgnRcvdPreHrcut + ", " +
				"initlMrgnRcvdPstHrcut=" + this.initlMrgnRcvdPstHrcut + ", " +
				"vartnMrgnRcvdPreHrcut=" + this.vartnMrgnRcvdPreHrcut + ", " +
				"vartnMrgnRcvdPstHrcut=" + this.vartnMrgnRcvdPstHrcut + ", " +
				"xcssCollRcvd=" + this.xcssCollRcvd +
			'}';
		}
	}

	/*********************** Builder Implementation of ReceivedMarginOrCollateral6  ***********************/
	class ReceivedMarginOrCollateral6BuilderImpl implements ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder {
	
		protected ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder initlMrgnRcvdPreHrcut;
		protected ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder initlMrgnRcvdPstHrcut;
		protected ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder vartnMrgnRcvdPreHrcut;
		protected ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder vartnMrgnRcvdPstHrcut;
		protected ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder xcssCollRcvd;
		
		@Override
		@RosettaAttribute("initlMrgnRcvdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnRcvdPreHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getInitlMrgnRcvdPreHrcut() {
			return initlMrgnRcvdPreHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateInitlMrgnRcvdPreHrcut() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder result;
			if (initlMrgnRcvdPreHrcut!=null) {
				result = initlMrgnRcvdPreHrcut;
			}
			else {
				result = initlMrgnRcvdPreHrcut = ActiveOrHistoricCurrencyAnd20DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initlMrgnRcvdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnRcvdPstHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getInitlMrgnRcvdPstHrcut() {
			return initlMrgnRcvdPstHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateInitlMrgnRcvdPstHrcut() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder result;
			if (initlMrgnRcvdPstHrcut!=null) {
				result = initlMrgnRcvdPstHrcut;
			}
			else {
				result = initlMrgnRcvdPstHrcut = ActiveOrHistoricCurrencyAnd20DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnRcvdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnRcvdPreHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getVartnMrgnRcvdPreHrcut() {
			return vartnMrgnRcvdPreHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateVartnMrgnRcvdPreHrcut() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder result;
			if (vartnMrgnRcvdPreHrcut!=null) {
				result = vartnMrgnRcvdPreHrcut;
			}
			else {
				result = vartnMrgnRcvdPreHrcut = ActiveOrHistoricCurrencyAnd20DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnRcvdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnRcvdPstHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getVartnMrgnRcvdPstHrcut() {
			return vartnMrgnRcvdPstHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateVartnMrgnRcvdPstHrcut() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder result;
			if (vartnMrgnRcvdPstHrcut!=null) {
				result = vartnMrgnRcvdPstHrcut;
			}
			else {
				result = vartnMrgnRcvdPstHrcut = ActiveOrHistoricCurrencyAnd20DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("xcssCollRcvd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xcssCollRcvd")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getXcssCollRcvd() {
			return xcssCollRcvd;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateXcssCollRcvd() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder result;
			if (xcssCollRcvd!=null) {
				result = xcssCollRcvd;
			}
			else {
				result = xcssCollRcvd = ActiveOrHistoricCurrencyAnd20DecimalAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("initlMrgnRcvdPreHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnRcvdPreHrcut")
		@Override
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder setInitlMrgnRcvdPreHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount _initlMrgnRcvdPreHrcut) {
			this.initlMrgnRcvdPreHrcut = _initlMrgnRcvdPreHrcut == null ? null : _initlMrgnRcvdPreHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initlMrgnRcvdPstHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnRcvdPstHrcut")
		@Override
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder setInitlMrgnRcvdPstHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount _initlMrgnRcvdPstHrcut) {
			this.initlMrgnRcvdPstHrcut = _initlMrgnRcvdPstHrcut == null ? null : _initlMrgnRcvdPstHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnRcvdPreHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnRcvdPreHrcut")
		@Override
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder setVartnMrgnRcvdPreHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount _vartnMrgnRcvdPreHrcut) {
			this.vartnMrgnRcvdPreHrcut = _vartnMrgnRcvdPreHrcut == null ? null : _vartnMrgnRcvdPreHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnRcvdPstHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnRcvdPstHrcut")
		@Override
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder setVartnMrgnRcvdPstHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount _vartnMrgnRcvdPstHrcut) {
			this.vartnMrgnRcvdPstHrcut = _vartnMrgnRcvdPstHrcut == null ? null : _vartnMrgnRcvdPstHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("xcssCollRcvd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("xcssCollRcvd")
		@Override
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder setXcssCollRcvd(ActiveOrHistoricCurrencyAnd20DecimalAmount _xcssCollRcvd) {
			this.xcssCollRcvd = _xcssCollRcvd == null ? null : _xcssCollRcvd.toBuilder();
			return this;
		}
		
		@Override
		public ReceivedMarginOrCollateral6 build() {
			return new ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Impl(this);
		}
		
		@Override
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder prune() {
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
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder o = (ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder) other;
			
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
		
			ReceivedMarginOrCollateral6 _that = getType().cast(o);
		
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
			return "ReceivedMarginOrCollateral6Builder {" +
				"initlMrgnRcvdPreHrcut=" + this.initlMrgnRcvdPreHrcut + ", " +
				"initlMrgnRcvdPstHrcut=" + this.initlMrgnRcvdPstHrcut + ", " +
				"vartnMrgnRcvdPreHrcut=" + this.vartnMrgnRcvdPreHrcut + ", " +
				"vartnMrgnRcvdPstHrcut=" + this.vartnMrgnRcvdPstHrcut + ", " +
				"xcssCollRcvd=" + this.xcssCollRcvd +
			'}';
		}
	}
}
