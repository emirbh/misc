package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Account;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.Trade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapAccountList.MapAccountListDefault.class)
public abstract class MapAccountList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAccount mapAccount;

	/**
	* @param fpmlTrade 
	* @param fpmlAccountList 
	* @return accountList 
	*/
	public List<? extends Account> evaluate(Trade fpmlTrade, List<? extends fpml.consolidated.shared.Account> fpmlAccountList) {
		List<Account.AccountBuilder> accountListBuilder = doEvaluate(fpmlTrade, fpmlAccountList);
		
		final List<? extends Account> accountList;
		if (accountListBuilder == null) {
			accountList = null;
		} else {
			accountList = accountListBuilder.stream().map(Account::build).collect(Collectors.toList());
			objectValidator.validate(Account.class, accountList);
		}
		
		return accountList;
	}

	protected abstract List<Account.AccountBuilder> doEvaluate(Trade fpmlTrade, List<? extends fpml.consolidated.shared.Account> fpmlAccountList);

	public static class MapAccountListDefault extends MapAccountList {
		@Override
		protected List<Account.AccountBuilder> doEvaluate(Trade fpmlTrade, List<? extends fpml.consolidated.shared.Account> fpmlAccountList) {
			if (fpmlAccountList == null) {
				fpmlAccountList = Collections.emptyList();
			}
			List<Account.AccountBuilder> accountList = new ArrayList<>();
			return assignOutput(accountList, fpmlTrade, fpmlAccountList);
		}
		
		protected List<Account.AccountBuilder> assignOutput(List<Account.AccountBuilder> accountList, Trade fpmlTrade, List<? extends fpml.consolidated.shared.Account> fpmlAccountList) {
			accountList.addAll(toBuilder(MapperC.<fpml.consolidated.shared.Account>of(fpmlAccountList)
				.mapItem(item -> MapperS.of(mapAccount.evaluate(item.get(), fpmlTrade))).getMulti()));
			
			return Optional.ofNullable(accountList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
